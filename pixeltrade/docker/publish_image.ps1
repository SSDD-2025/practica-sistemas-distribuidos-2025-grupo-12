$DockerUser = "dmunozm5"
$ImageName = "pixeltrade"
$Tag = "latest"

$FullImageName = "$DockerUser/$ImageName:$Tag"

Write-Host "Tagging image as $FullImageName..."
docker tag "$ImageName:$Tag" $FullImageName

Write-Host "Pushing image to Docker Hub..."
docker push $FullImageName

if ($LASTEXITCODE -ne 0) {
    Write-Host "Failed to push the image." -ForegroundColor Red
    exit $LASTEXITCODE
}

Write-Host "Image published successfully: $FullImageName" -ForegroundColor Green
