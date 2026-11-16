# Network access of the elasticsearch deployment (corp landing zone).

module "egress_01" {
  source           = "../modules/private-link-consumer"
  endpoint_service = "com.corp.privatelink.equity-derivatives-order-router"
  port             = 443
}

# Deposits Product Catalog AMER
module "egress_02" {
  source           = "../modules/private-link-consumer"
  endpoint_service = "com.corp.privatelink.ext-gw-457"
  port             = 443
}

# Cash Management Settlement Engine
module "egress_03" {
  source           = "../modules/private-link-consumer"
  endpoint_service = "com.corp.privatelink.ext-gw-948"
  port             = 443
}

data "aws_security_group" "peer_04" {
  tags = {
    Application = "Credit Hedging Service EMEA"
  }
}

resource "aws_security_group_rule" "ingress_04" {
  type                     = "ingress"
  from_port                = 8443
  to_port                  = 8443
  protocol                 = "tcp"
  security_group_id        = var.service_sg_id
  source_security_group_id = data.aws_security_group.peer_04.id
}

data "aws_security_group" "peer_05" {
  tags = {
    Application = "Identity Log Collector"
  }
}

resource "aws_security_group_rule" "ingress_05" {
  type                     = "ingress"
  from_port                = 8443
  to_port                  = 8443
  protocol                 = "tcp"
  security_group_id        = var.service_sg_id
  source_security_group_id = data.aws_security_group.peer_05.id
}
