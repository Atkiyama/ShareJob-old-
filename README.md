# ShareJob


## はじめに 
本アプリケーションは現在制作中なので機能に関しては未実装なものが大半となります。
## このアプリケーションについて

本アプリケーションは就職活動を支援するアプリケーションです。本アプリケーションでは以下のことができます。

- 自分の気になる企業の登録
- 登録した企業の進捗状況の記録
- グループ内での情報共有

## 使用言語・環境について

使用言語は以下のものです。

- OS:MAC OS(Moneterey 12.6.1),ubuntu:20.04
- 開発言語:Java(Spring boot) JavaScript(Vue.js)

## 　機能について

準備中
## 環境構築方法
各バージョンを以下に揃える必要があります。またmavenのインストールが必要になります
- java:11
- node v16.17.0
- npm 8.15.0

### MAC OSの場合

##### 1 HomeBrewのインストール

以下のコマンドでまずは[Homebrew](https://brew.sh/index_ja)をインストールしておいてください

``` sh : grepVer3.sh

/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
```

##### 2 javaのインストール

以下のコマンドでjava11をインストールしてください。
``` sh : grepVer3.sh
brew install java11
```
指示があればインストールのメッセージにある通り環境変数を設定してください

``` sh : grepVer3.sh
If you need to have openjdk@11 first in your PATH run:
  echo 'export PATH="/usr/local/opt/openjdk@11/bin:$PATH"' >> ~/.zshrc

For compilers to find openjdk@11 you may need to set:
  export CPPFLAGS="-I/usr/local/opt/openjdk@11/include"

% echo 'export PATH="/usr/local/opt/openjdk@11/bin:$PATH"' >> ~/.zshrc
% export CPPFLAGS="-I/usr/local/opt/openjdk@11/include"
% source ~/.zshrc

```
##### 3 nodebrewのインストール
まずnodebrewをインストールしてインストールできるバージョンを確認します

``` sh : grepVer3.sh
brew install nodebrew
nodebrew ls-remote
```

以下のようなエラーが出る場合はsetupコマンドを打ってください
``` sh : grepVer3.sh
Fetching: https://nodejs.org/dist/v7.10.0/node-v7.10.0-darwin-x64.tar.gz
Warning: Failed to create the file 
Warning: /Users/whoami/.nodebrew/src/v7.10.0/node-v7.10.0-darwin-x64.ta
Warning: r.gz: No such file or directory

curl: (23) Failed writing body (0 != 941)
download failed: https://nodejs.org/dist/v7.10.0/node-v7.10.0-darwin-x64.tar.gz
```

setupコマンド
``` sh : grepVer3.sh
nodebrew setup
```
##### 4 node,npmのインストール

以下コマンドでnodeをインストールしてください。npmは自動的にインストールされます
``` sh : grepVer3.sh
nodebrew install-binary v16.17.0
```

その後このコマンドを打ってパスを通すことでnodeが使用可能になります。
``` sh : grepVer3.sh
nodebrew use v7.1.0
```

- bashの場合
``` sh : grepVer3.sh
echo 'export PATH=$HOME/.nodebrew/current/bin:$PATH' >> ~/.bash_profile
```

- zshの場合
``` sh : grepVer3.sh
echo 'export PATH=$HOME/.nodebrew/current/bin:$PATH' >> ~/.zprofile
```
追記した後、ターミナルを再起動もしくはsourceコマンドで環境パスを読み込んでください

###### sourceコマンド
``` sh : sdf.sh
source ~/.zshrc
```

##### 5 mavenのインストール

以下コマンドで簡単にインストールできます
``` sh : sdf.sh
brew install maven
```

##### 6 vuecliのインストール

以下コマンドで簡単にインストールできます
``` sh : sdf.sh
npm install -g @vue/cli
```

### Dockerを使う場合

Dockerfileを元にイメージ作ってコンテナを立ち上げてください

## 起動方法

##### インストール
git cloneでローカル環境に本アプリケーションをインストールします

``` sh: dfs.sh
git clone https://github.com/Atkiyama/ShareJob.git
```

##### ビルド
以下コマンドでビルドできます

``` sh: dfs.sh

mvn clean package
```

##### 実行とアクセス

以下のコマンドを実行し http://localhost:3000 にアクセスすることで本アプリケーションを実行できます
``` sh: dfs.sh
java -jar target/ShareJob-0.0.1-SNAPSHOT.jar
```

### 仮IDについて
現在、二つの仮IDが用意されています。テストにご使用ください。
| ユーザ名 | ユーザID | パスワード | 
| -------- | -------- | ---------- | 
| ID1      | id1      | id1        | 
| ID2      | id2      | id2        | 