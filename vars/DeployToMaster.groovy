def call(Map config) {
    sh """
        docker pull ${config.dockerUser}/nodemain:${config.imageTag}
        docker stop main-app || true
        docker rm main-app || true
        docker run -d --name main-app --expose 3000 -p 3000:3000 ${config.dockerUser}/nodemain:${config.imageTag}
    """
}