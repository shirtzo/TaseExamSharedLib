def call() {
    echo "Commit hash: ${env.GIT_COMMIT}"
    echo "Committer name: ${env.GIT_COMMITTER_NAME}"
    echo "git url: ${env.GIT_URL}"
}
