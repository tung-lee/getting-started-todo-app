pipeline {
    agent {
        label 'test-dev-battle-server'
    }
    stages {
        stage('info') {
            steps {
                sh(script: """ whoami;pwd;ls -la """, label: "first stage")
            }
        }
    }
}
