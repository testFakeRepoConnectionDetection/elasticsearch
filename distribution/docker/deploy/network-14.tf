# Network access of the elasticsearch deployment (corp landing zone).

# Messaging Data Lake Loader AMER
module "egress_01" {
  source           = "../modules/private-link-consumer"
  endpoint_service = "com.corp.privatelink.ext-gw-207"
  port             = 443
}

data "aws_security_group" "peer_02" {
  tags = {
    app_code = "AP57369"
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
  endpoint_service = "com.corp.privatelink.app-ap72676"
  port             = 443
}

module "egress_04" {
  source           = "../modules/private-link-consumer"
  endpoint_service = "com.corp.privatelink.cac-product-catalog-apac"
  port             = 443
}
