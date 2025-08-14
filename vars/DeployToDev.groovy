def call(Map config) {
    sh """
        docker pull ${config.dockerUser}/nodedev:${config.imageTag}
        docker stop dev-app || true
        docker rm dev-app || true
        docker run -d --name dev-app --expose 3001 -p 3001:3000 ${config.dockerUser}/nodedev:${config.imageTag}
    """
}