node {
 stage 'checkout'
  checkout scm

 stage 'build'
  sh "./gradlew clean build"

  publishHTML(target:[allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'snackengage_lib/build/outputs/', reportFiles: "lint-results-debug.html", reportName: 'Lint'])

  step([$class: 'JUnitResultArchiver', testResults: 'snackengage_lib/build/test-results/*/*.xml'])
     
}