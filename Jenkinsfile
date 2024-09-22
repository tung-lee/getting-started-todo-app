pipeline {
    agent none  // We'll define the agent in each stage

    stages {
        stage('info') {
            agent {
                label {
                    // Choose agent based on branch name
                    switch(env.BRANCH_NAME) {
                        case 'main':
                            return 'production-server'
                        case 'dev':
                            return 'test-dev-battle-server'
                        default:
                            return 'default-agent'
                    }
                }
            }
            steps {
                sh(script: """ whoami;pwd;ls -la """, label: "first stage")
            }
        }
    }
}
