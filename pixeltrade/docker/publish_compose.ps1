$DockerUser = "dmunozm5"
$ImageName = "pixeltrade"
$Tag = "1.0.0"
$File = "docker-compose.prod.yml"

$FullImageName = "${DockerUser}/${ImageName}-compose:${Tag}"

Write-Host "Publishing $ImageName as OCI Artifact to $FullImageName"

docker compose -f ${File} publish ${FullImageName} --with-env

Write-Host "Published successfully!" -ForegroundColor Green

