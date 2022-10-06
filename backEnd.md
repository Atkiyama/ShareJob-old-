#バックエンド側の構造について

##処理のフロー
1. schema.sqlが起動してテーブルを作成、その後data.sqlで初期データが代入される
2. vue側からidとパスワードがPOSTされる。これをcontroller.LoginControllerで受け取る。(受け取るデータはform.LoginFormで定義される)
3. LoginControllerがservice.impl.UserServiceImplを呼び出す。
4. UserServiceImplがrepository.UserRepositoryを呼び出す
5. UserRepositoryがSQLにてIDと合致するユーザ情報(model.MUser)を検索して呼び出す
6. repository->service->controllerとユーザ情報が伝達
7. ユーザ情報をjsonで返す形に整形(Muserをmodel.view.MainViewUserに整形)
8. 整形した情報をVue側にreturnする

##パッケージの詳細
* src/main/java
    * aspect 
        * デバックログなどに関連する処理が記述される
    * config
        * 細かな設定(セキュリティ関連)にに関する処理が記述される
        * 現在の挙動には影響しない
    * controller
        * vue側のリクエストがあった時に真っ先に呼び出される
        * 必要な情報をServiceから受け取って返す
    * form
        * POSTされる情報を定義する
        * controllerに引数として渡される
    * model
        * データ型を定義する
        * view 
            * JSONで返す際のデータ型を定義する
    * repository
        * SQLでのデータベースの検索を行う
        * Serviceから呼び出される
    * service
        * controllerから呼び出される
        * 必要に応じてrepositoryを呼び出し、必要なデータをcontrollerに返す
        * ここではインターフェースのみ定義される
        * impl 
            * serviceの実装を行う

* src/main/resourses
    * i18n
        * プロパティに関する設定が記述される
        * 現在の挙動には影響しない
    * mapper/h2
        * O/RマッパーのMybaitsを使う時にはここにSQLを入れる
        * 現在の挙動には影響しない
    
##各クラスの詳細

* src/main/java
    * aspect 
        * ErrorAspect
            * エラー時のログを定義
        * GlobalControllerAdvice
            * そのほかのログの定義
        * LogAspect
            * ServiceやContorllerの起動時のログの定義
    * config
        * SecurityConfig
            * 認証処理を書く(予定)
    * controller
        * LoginController
            * ログイン時のController 
            * IDとパスワードを受け取ってSeerviceから情報を受け取る
            * 受け取った情報を変換して返す
        * ProfileController
            * 現在未使用
    * form
        * MainForm
            * 現在未使用
        * LoginForm
            * Login時にPOSTされる情報を定義する
    * model
        * Company
            * 会社の情報を定義
            * ユーザが保持
        * Event
            * 企業のイベントを定義
            * companyクラスが保持(する予定)
            * 現在は未使用
        * Grade
            * Enumで学年(B3,B4,M1など)を定義
            * 現在は未使用
        * MUser
            * ユーザ情報を定義
        * view 
            * MainViewUser
                * MUserをメイン画面用に整形したもの
    * repository
        * UserRepository
            * UserServiceImplから呼び出される
            * IDと合致するユーザをServiceに返す
            * 現在はJPAで実装されている
    * service
        * UserService
            * LoginControllerから呼び出される
            * UserRepositoryを呼び出し、必要なデータをLoginControllerに返す
            * ここではインターフェースのみ定義される
            * impl 
                * UserServiceImpl 
                    * UserServiceの実装を行う

    * ShareJobApplication
        * アプリケーションを起動する　
##その他ファイルの詳細

現在の処理に関わる部分のみ記述
* src/main/resourses
    * apprication.propaties
        * h2データベース、JPA、ログ、SQLの設定が記述されている
    * data.sql 
        * データベースの初期値を代入している
    * schema.sql
        * 起動時に表を生成する

* pom.xml
    * 様々な設定を記述する
    * 以下に主要なものを抜粋する
        * ビルド関連
        * java,npm,nodeのバージョン
        * jquery
        * bootstrap
        * SpringSecurity
        * jpa






