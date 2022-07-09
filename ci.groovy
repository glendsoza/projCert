pipeline {
    agent any
    stages {
        stage('Run the playnook') {
            steps {
                sh 'cd $WORKSPACE && rm -rf *'
                sh 'git clone https://github.com/glendsoza/projCert.git'
                    sh 'ansible-playbook --inventory /tmp/inv $WORKSPACE/cicd-pipeline-train-schedule-autodeploy/deploy-kube.yml --extra-vars "env=qa build=$BUILD_NUMBER"'
                }
                post { 
                    always { 
                        cleanWs() 
                }
            }
            }
        }
}