pipeline {
    label 'test-dev-battle-server'
    stages {
        stage('info') {
            steps {
                sh(""" whoami;pwd;ls -la """, label: "first stage")
            }
        }
    }
}
