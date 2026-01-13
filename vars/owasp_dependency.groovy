def call() {
  withCredentials([usernamePassword(credentialsId: 'oss-index-creds', usernameVariable: 'OSS_INDEX_USERNAME', passwordVariable: 'OSS_INDEX_PASSWORD')]) {
    def args = "--scan ./ --disableNodeAudit --ossIndexUsername $OSS_INDEX_USERNAME --ossIndexPassword $OSS_INDEX_PASSWORD"
    dependencyCheck additionalArguments: args, odcInstallation: 'OWASP'
  }
  dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
}
