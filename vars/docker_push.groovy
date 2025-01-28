def call(String Project, String ImageTag, String DockerHubUser){
  withCredentials([usernamePassword(credentialsId: 'dockerHubCred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) {
      sh "docker login -u ${DockerHubUser} -p ${dockerHubPass}"
  }
  sh "docker push ${DockerHubUser}/${Project}:${ImageTag}"
}
