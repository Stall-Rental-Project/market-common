pipeline {
    agent any
    stages {
        stage("Maven build and Deploy") {
            agent {
                docker {
                    image 'maven:3.6.3-jdk-11'
                    args '-v /home/jenkins/.m2:/root/.m2 --network=host'
                    reuseNode true
                }
            }
            steps {
                sh 'mvn -s /root/.m2/settings.xml -q -U clean install deploy -Dmaven.test.skip=true'
            }
        }
    }
}
