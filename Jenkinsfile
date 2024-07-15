pipeline {
	agent any

	environment {
		NEW_VERSION = '1.3.0'
		SERVER_CREDENTIALS = credentials('server-credentials')
		AWS = credentials('aws')
	}

	stages {
		stage('webhook') {
			steps {
				echo 'webhook...'
			}
		}
		
		stage('build') {
			when {
				expression {
					BRANCH_NAME == 'dev'
				}
			}
			
			steps {
				echo 'build...'
			}
		}

		stage('test') {
			steps {
				echo 'test...'
				echo "test version ${NEW_VERSION}"
			}
		}

		stage('deploy') {	
			steps {
				echo 'deploy...'
				echo "deploying with ${SERVER_CREDENTIALS}" | base64
				echo "ssh EC2 ${AWS}" | base64
				sh '$AWS'
			}
		}
	}

	post {
		always {
			echo 'finally...'
		}
	}
}
