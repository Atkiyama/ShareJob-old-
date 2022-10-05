/* ユーザーマスタ */
INSERT INTO m_user (
    user_id VARCHAR(50) 
  , password VARCHAR(100)
  , user_name VARCHAR(50)
  , company_id ARRAY<VARCHAR(50)> 
  ,company_memo MAP<VARCHAR(50) ,VARCHAR(100)>

) VALUES
('id1', 'id1','ID1',ARRAY('company1'),MAP('company1','内定承諾'))
,('id2', 'id2','ID2',ARRAY('company2'),MAP('company2','もしもしポリスメン?'))
;

/* 会社マスタ */
INSERT INTO company (
  conpany_id VARCHAR(50) 
  , company_name VARCHAR(100)
  , company_abstract VARCHAR(2000)

) VALUES
('company1', 'マクロコスモス','ガラル地方のポケモンリーグ委員長のローズが経営する企業グループ（所謂財閥）。ポケモンリーグの筆頭スポンサーでもある。ちなみにマクロコスモスとは「大宇宙」の意味。 (後述の活躍から「黒幕」にもかけているものと思われる。) 事業は建設業、保険業、航空業など多岐にわたっており、ローズタワーにはマクロコスモス関連企業が多く入居している。関連会社の一つマクロコスモス・コンストラクションはポケモン勝負が可能なエレベータの開発など高い技術力を持っている。 
中盤以降はポケジョブの募集要項にも幾つか顔を出すようになる。 「マクロ」が名前に含まれる組織は共通して「C」の字を元にしたロゴマークとなっている。 ')
,('company2', '竹書房','竹書房ゥァア゛ーッ')
;

/* ユーザーマスタ */
INSERT INTO company_memo (
    user_id VARCHAR(50) 
    conpany_id VARCHAR(50) 
    conpany_memo VARCHAR(100) 
  ,

) VALUES
('id1', 'company1','内定承諾')
,('id2', 'company2','もしもしポリスメン?')
;
