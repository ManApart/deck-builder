# Deck Builder

POC of a card based deck building game. 

## Deploying
```
./gradlew browserDistribution && aws s3 sync build/distributions/ s3://austinkucera.com/games/deck-builder/
```