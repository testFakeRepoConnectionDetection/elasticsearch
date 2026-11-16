# Network access of the elasticsearch deployment (corp landing zone).

module "egress_01" {
  source           = "../modules/private-link-consumer"
  endpoint_service = "com.corp.privatelink.sepa-statement-generator-apac"
  port             = 443
}
