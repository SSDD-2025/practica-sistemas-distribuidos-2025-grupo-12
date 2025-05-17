$DockerUser = "dmunozm5"
$ImageName = "pixeltrade"
$Tag = "1.0.0"

$FullImageName = "${DockerUser}/${ImageName}:${Tag}"

docker login

Write-Host "Tagging image as ${FullImageName}..."
docker tag "${ImageName}:${Tag}" ${FullImageName}

Write-Host "Pushing image to Docker Hub..."
docker push ${FullImageName}
Write-Host "Image published successfully: $FullImageName" -ForegroundColor Green
