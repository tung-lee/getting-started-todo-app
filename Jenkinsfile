pipeline {
	agent any

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
			}
		}

		stage('deploy') {	
			steps {
				echo 'deploy...'
			}
		}
	}

	post {
		always {
			echo 'finally...'
		}
	}
}
