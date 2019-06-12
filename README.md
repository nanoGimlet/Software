# ソフトウェア制作用

## 独り言
(6/10)
・多分想定してるCUIの原型ができたと思う。一番てこずったのはスレッドを配列のようにして全員に受け取った文字を送信するやつ。  
・今は嬉しくなって取り敢えずpushしたけどもう少し読みやすくするのとコメント付けますね。
・取り敢えず各自進捗を生んだらLINEで報告してくれ。  
・あと僕がこれ作ってるときに僕らの目指してるやつの原型みたいなやつ見つけたのでリンクを貼っときます。  
  [GUI付き](http://www.rsch.tuis.ac.jp/~ohmi/software-basic/network4.html "GUI付き")  
(6/1)
・特に変わってない。今までのやつをクラスにわけてGUIのときになるべく分裂できるようにした。  
・やっぱりCUIができないとお話にならなそう。中間報告にはCUIを完成させたい。  
・僕の明日までの目標はサーバーに送られてきたやつを全員のクライアントに表示できるようにする。  
・まさあきとりょうごにもついに仕事を分けたいと思うからアウトラインのPDFを読んでくれ。コードの説明は分からなかったら言ってくれ。  
(5/24)  
・３つ目のやつが多分今回のソフトウェアの原型になると思う。まさきとかまさのりに言われたけどある程度原型ができてきたらいったんクラスごとに分けてみるといいみたい。  
・あとGUIってCUIにあとからくっつけられるのかと思ってたけどどうやらいきなりGUIで作ってもいいみたいだからこれはまた後で考える。  
・僕の次のタスクはクラス考えてできればみんなに割り振れるよう努力します。  


## 授業のメモ
[第１回](./softmemo.txt)  

## アウトライン
[Outline](./Outline2.pdf)  

## １対多での複数の文字列をサーバーに送信し、クライアントに送られたデータを返す
[サーバー：](./ChannelServer.java)  
[クライアント：](./ChannelClient.java)  
[読み書きクラス：](./ReadWrite.java)  
[データ送信クラス：](./SendThread.java)  
[サーバーのデータ表示クラス：](./PresentThread.java)  

## 多分想定してるソフトの原型（まだ汚い）
[Server:](./ChatServer.java)  
[Serverに必要なクラス:](./ServerThread.java)  
[Client:](./ChatClient.java)  
[Clientに必要なクラス（接続と文字表示）](./Connect.java)
[Clientに必要なクラス（文字送信）](./Reaction.java)  
[共通クラス:](./ReaderWriter.java)  