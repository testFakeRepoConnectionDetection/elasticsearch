# Network access of the elasticsearch deployment (corp landing zone).

module "egress_01" {
  source           = "../modules/private-link-consumer"
  endpoint_service = "com.corp.privatelink.app-ap95174"
  port             = 443
}

data "aws_security_group" "peer_02" {
  tags = {
    app_alias = "EQDORDROU"
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

module "egress_03" {
  source           = "../modules/private-link-consumer"
  endpoint_service = "com.corp.privatelink.swfpayhub-am"
  port             = 443
}

module "egress_04" {
  source           = "../modules/private-link-consumer"
  endpoint_service = "com.corp.privatelink.news-sentiment-api"
  port             = 443
}

data "aws_security_group" "peer_05" {
  tags = {
    app = "fx-execution-gateway-emea"
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
