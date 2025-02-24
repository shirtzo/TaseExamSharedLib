def call() {
    def scmVars = checkout([
        $class: 'GitSCM',
        branches: [[name: '*/main']],
        userRemoteConfigs: [[url: 'https://github.com/shirtzo/TaseExam.git']],
        extensions: [[$class: 'CloneOption', depth: 0, noTags: false]]
      ])

      // Display the variable using scmVars
      echo "scmVars.GIT_COMMIT"
      echo "${scmVars.GIT_COMMIT}"

      // Displaying the variables saving it as environment variable
      env.GIT_COMMIT = scmVars.GIT_COMMIT
      echo "env.GIT_COMMIT"
      echo "${env.GIT_COMMIT}"
      
    def committerName = sh(script: "git --no-pager show -s --format='%cn' ${env.GIT_COMMIT}", returnStdout: true).trim()
    def committerEmail = sh(script: "git --no-pager show -s --format='%ae' ${env.GIT_COMMIT}", returnStdout: true).trim()

    return [
        codeCommiter: committerName,
        codeCommiterEmail: committerEmail,
        commitHash: env.GIT_COMMIT, 
        gitUrl: env.GIT_URL
    ]
}
