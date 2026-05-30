terraform {
  required_providers {
    local = {
      source  = "hashicorp/local"
      version = "~> 2.5"
    }
  }
}

resource "local_file" "practice" {
  filename = "${path.module}/hello-terraform.txt"
  content  = "Terraform created this file."
}