#!/bin/bash

TARGET="${HOME}/mnt/atom/public_html/jnlp"
GOALS="webstart-helloworld webstart-swing webstart-clock"

if [ ! -d ${TARGET} ]
then
    echo ${TARGET} is not a directory! Please mount Atom server!
    exit 1
fi

TARGET=${TARGET}/`pwd | xargs basename`
rm -rf ${TARGET}
mkdir ${TARGET} &>/dev/null

for goal in ${GOALS}
do
    mvn clean install org.codehaus.mojo.webstart:webstart-maven-plugin:jnlp -D${goal}
    cp target/jnlp/*.jnlp target/jnlp/*.jar ${TARGET}
done
