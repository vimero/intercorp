node {
    def mvnHome
    def dockerImage
    def dockerImageName = "intercorp"
    stage('Preparation') {
        git branch: 'pipeline', credentialsId: '2fa742ec-da4c-4f61-a305-dae412181cd8', url: 'https://github.com/vimero/intercorp'
        mvnHome = tool 'M3'
    }
    stage('Build') {
        withEnv(["MVN_HOME=$mvnHome"]) {
            if (isUnix()) {
                sh '"$MVN_HOME/bin/mvn"  clean package'
            } else {
                bat(/"%MVN_HOME%\bin\mvn" clean package/)
            }
        }
    }
    stage('Coverage') {
        withEnv(["MVN_HOME=$mvnHome"]) {
            if (isUnix()) {
                sh '"$MVN_HOME/bin/mvn"  -Dmaven.test.skip=false -Djacoco-skip=false clean package'
            } else {
                bat(/"%MVN_HOME%\bin\mvn" -Dmaven.test.skip=false -Djacoco-skip=false clean package/)
            }
        }
    }
    stage('Package') {
        sh "whoami"
        sh "ls -all /var/run/docker.sock"
        sh "mv ./target/intercorp*.jar ./data"
        dockerImage = docker.build(dockerImageName)
    }
    stage('Deploy') {
        sh "docker-compose down"
        echo "Docker Compose"
        sh "docker-compose up -d"
    }
}