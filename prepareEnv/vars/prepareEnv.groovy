def prepareEnv() {
    def committerName = env.GIT_COMMITTER_NAME
    echo "code written by: ${committerName}"
}
