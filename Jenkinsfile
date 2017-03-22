node {
 stage 'checkout'
  checkout scm

 stage 'build'
  sh "./gradlew clean build"

  publishHTML(target:[allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'snackengage-core/build/outputs/', reportFiles: "lint-results-debug.html", reportName: 'Lint'])

  step([$class: 'JUnitResultArchiver', testResults: 'snackengage-core/build/test-results/*/*.xml'])
     
}