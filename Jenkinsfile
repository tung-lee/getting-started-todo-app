pipeline {
    label 'test-dev-battle-server'
    stages {
        stage('info-test') {
            steps {
                sh(""" whoami;pwd;ls -la """, label: "first stage")
            }
        }
    }
}
