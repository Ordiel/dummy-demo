#! /bin/bash -e

: "${JENKINS_HOME:="/var/jenkins_home"}"

echo "Re-branding Jenkins..."
mkdir -p $JENKINS_HOME/userContent/layout
cp -r /tmp/jenkins_layout/* $JENKINS_HOME/userContent/layout/
echo "Jenkins Re-branded..."
exec $@