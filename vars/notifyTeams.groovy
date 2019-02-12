#!/usr/bin/env groovy


def call(String url, String buildStatus) {
  def color
  def status

  switch (buildStatus) {
    case 'SUCCESS':
      color = '28a745'
      status = 'succeded'
      break

    case 'UNSTABLE':
      color = 'ffc107'
      status = 'is unstable'
      break

    case 'FAILURE':
      color = 'dc3545'
      status = 'failed'
      break
  }

  office365ConnectorSend message: 'Build ' + status, status: buildStatus, color: color, webhookUrl: url
}
