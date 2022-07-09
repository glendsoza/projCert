pipeline {
    agent any
    stages {
        stage('Run the playnook') {
            steps {
                sh 'cd $WORKSPACE && rm -rf *'
                sh 'git clone https://github.com/glendsoza/projCert.git'
                    sh 'ansible-playbook --inventory /tmp/inv $WORKSPACE/projCerty/deploy-php.yml --extra-vars "env=test build_tag=$BUILD_NUMBER"'
                }
                post { 
                    always { 
                        cleanWs() 
                }
            }
            }
        }
}