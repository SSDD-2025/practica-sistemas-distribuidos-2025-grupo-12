$DockerUser = "dmunozm5"
$ImageName = "pixeltrade"
$Tag = "latest"
$File = "docker-compose.prod.yml"

$FullImageName = "$DockerUser/$ImageName:$Tag"

Write-Host "Publishing $ImageName as OCI Artifact to $FullImageName"

docker compose -f $File publish $FullImageName

Write-Host "Published successfully!" -ForegroundColor Green

