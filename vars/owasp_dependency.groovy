def call(){
  dependencyCheck additionalArguments: '--scan ./ --disableNodeAudit', odcInstallation: 'OWASP'
  dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
}
