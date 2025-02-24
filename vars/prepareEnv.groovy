def call() {
    def scmVars = checkout([
        $class: 'GitSCM',
        branches: [[name: '*/main']],
        userRemoteConfigs: [[url: 'https://github.com/shirtzo/TaseExam.git']],
        extensions: [[$class: 'CloneOption', depth: 0, noTags: false]]
    ])

    def committerName = sh(script: "git --no-pager show -s --format='%an' ${scmVars.GIT_COMMIT}", returnStdout: true).trim()
    def committerEmail = sh(script: "git --no-pager show -s --format='%ae' ${scmVars.GIT_COMMIT}", returnStdout: true).trim()

    return [
        gitCommitHash: scmVars.GIT_COMMIT,
        gitUrl: scmVars.GIT_URL,
        gitBranch: scmVars.GIT_BRANCH,
        committerName: committerName,
        committerEmail: committerEmail
    ]
}
