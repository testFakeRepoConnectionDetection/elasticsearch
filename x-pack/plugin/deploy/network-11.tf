# Network access of the elasticsearch deployment (corp landing zone).

# Equity Derivatives Order Router EMEA
module "egress_01" {
  source           = "../modules/private-link-consumer"
  endpoint_service = "com.corp.privatelink.ext-gw-779"
  port             = 443
}

data "aws_security_group" "peer_02" {
  tags = {
    Application = "Equity Derivatives Pricing Engine"
  }
}

resource "aws_security_group_rule" "ingress_02" {
  type                     = "ingress"
  from_port                = 8443
  to_port                  = 8443
  protocol                 = "tcp"
  security_group_id        = var.service_sg_id
  source_security_group_id = data.aws_security_group.peer_02.id
}

data "aws_security_group" "peer_03" {
  tags = {
    app = "corporate-accounts-account-ledger-amer"
  }
}

resource "aws_security_group_rule" "ingress_03" {
  type                     = "ingress"
  from_port                = 8443
  to_port                  = 8443
  protocol                 = "tcp"
  security_group_id        = var.service_sg_id
  source_security_group_id = data.aws_security_group.peer_03.id
}

# Regulatory Reporting Evidence Archive EMEA
module "egress_04" {
  source           = "../modules/private-link-consumer"
  endpoint_service = "com.corp.privatelink.ext-gw-224"
  port             = 443
}

module "egress_05" {
  source           = "../modules/private-link-consumer"
  endpoint_service = "com.corp.privatelink.messaging-data-lake-loader-amer"
  port             = 443
}
