#フロントエンド側のドキュメント

## 参考資料
Vue, Vuex, Vue Routerを使用したアプリケーション開発（フロント）
Vuexとは、Vue.js アプリケーションのための 状態管理パターン + ライブラリです。

参照: https://vuex.vuejs.org/ja/ 

Vue Routerとは、Vue.js アプリケーションでSPA構築を行うための ルーティング制御ライブラリ です。

参照: https://router.vuejs.org/introduction.html 



##フロントエンド側の構造について

- frontend/src/assets (画像やフォントを格納するディレクトリ)

- frontend/src/assets/logo/png (vueアイコンのロゴ)



- frontend/src/components (単一ファイルコンポーネントを格納するディレクトリ)

- frontend/src/components/JobList.vue (仕事リストのカード)

- frontend/src/router (Vue.jsを利用したSPA構築で、ルーティング制御をするための公式プラグイン)

- frontend/src/router/index.js (home, login, logout, sign-up, profile,ページへのルーティングを記述)

- frontend/src/store (Vuexのstoreパターンを定義)

- frontend/src/store/userLogin (ユーザログイン状態の記述)

- frontend/src/store/jobList (ユーザ名と仕事リストの記述)

- frontend/src/views (各ページのview単位での記述)

- HomeView.vue (ホーム)

- LoginForm.vue (ログインフォーム)

- LogoutView.vue (ログアウト)

- PageHeader.vue (ページヘッダー部)

- ProfileView.vue (プロフィールページ)

- SignUp.vue (ユーザ登録)

- TopView.vue (トップページ)

- frontend/src/main.js (Vueの基本設定ファイル。App.vueをhtmlに紐付ける)

- frontend/src/App.vue (アプリケーションのルートになるコンポーネント)

- frontend/src/package.json (npmのモジュール、タスクを定義)