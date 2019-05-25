stage ('Artifactory-Config')
{
def server = Artifactory.server('JFrog_Art1')
server = Artifactory.newServer url: 'http://52.167.59.104:8081/artifactory/', username: 'admin', password: 'password'
def uploadSpec = """{
  "files": [
    {
      "pattern": "./target/*.war",
      "target": "Snapshot/${BUILD_NUMBER}/"
    }
 ]
}"""
server.upload(uploadSpec)
 

}
