; NeverNoid-2 The Editor ; copyright 1987-1993 ; by A.A. van de Woestijne & R.H. Keizer  drive$="sys:" � InitVariables � InitMap � Loadroutine �7 150 �4 � InitScreen � BackBlockPrint � Background � ShowLevel � ShowBlock � LevelBankPrint � PrintBlocks   .MainRoutine ��   � Joystick   � KeyRead   � BlockHits   � MoveSprite   � BlitIt �� � (69) �  .InitVariables: drawblock=0 hits=1 sy=1 lvl=0 bckgrnd=65 delete.b=0 min1=121:min2=124:sec1=121:sec2=121 playtime=18 lvbnk.b=1 maxextras=10 extras=0 �  .InitMap: � .blocks   blocknr.b   hits   extra   lr   points � � � level.blocks(31,15,15) size.l=32*16*16*6 � info.blocks(31) infosize.l=32*6 � BlockMap.b(4,12) �  .Loadroutine: �5 � 0,320,256,4 � 0,drive$+"graphics/EditorScreen",0 �
 0,drive$+"graphics/blokken216" � 120,drive$+"graphics/Cursor.Iff" �
 121,drive$+"graphics/EditorText" � 160,drive$+"graphics/t116.iff" � 161,drive$+"graphics/t216.iff" � 162,drive$+"graphics/t316.iff" � 0,120 �+ � 120 �  .InitScreen: �4 � 0,44,320,256,$fff8,4,8,16,320,320 � 0 �, �	 0 � 0,8000 � 0 : � 2 �  .BlitIt: �7 � lvl<9 �! � 121,124,4 : � 122+lvl,132,4 � lvl>8 �! � lvl<19 �! � 122,124,4 : � 112+lvl,132,4 � lvl>18 �! � lvl<29 �! � 123,124,4 : � 102+lvl,132,4 � lvl>28 �! � lvl<39 �! � 124,124,4 : � 92+lvl,132,4 � score= 5 �! � 121,278,89 : � 126,285,89 � score=10 �! � 122,278,89 : � 121,285,89 � score=15 �! � 122,278,89 : � 126,285,89 � score=20 �! � 123,278,89 : � 121,285,89 � score=25 �! � 123,278,89 : � 126,285,89 � score=30 �! � 124,278,89 : � 121,285,89 � 0 � btext=1 �! � 0,160,45,200 � btext=2 �! � 0,161,50,202 � btext=3 �! � 0,162,15,202 � 131,195,4 � min1,180,4 : � min2,188,4 � sec1,202,4 : � sec2,210,4 � 121+lvbnk,72,4 : � 121,64,4 �   .MapToTime: ti=info(lvl)\points � ti>0   � ti=3 �! min2=121 : sec1=124   � ti=6 �! min2=122 : sec1=121   � ti=9 �! min2=122 : sec1=124   � ti=12 �! min2=123 : sec1=121   � ti=15 �! min2=123 : sec1=124   � ti=18 �! min2=124 : sec1=121   � ti=21 �! min2=124 : sec1=124   � ti=24 �! min2=125 : sec1=121   � ti=27 �! min2=125 : sec1=124   � ti=30 �! min2=126 : sec1=121 �� �  .Joystick: waiting+1 � waiting<3 �! � waiting=0 fire=0 � x �B 1 �! � sx=2 �! fire=1 � �(1)=1 �! x+sx � �(1)=-1 �! x-sx � �(1)=1 �! y+sy � �(1)=-1 �! y-sy � x<fire �! x=fire � x>(14-fire) �! x=14-fire � y<0 �! y=0 � y>15 �! y=15 sx=1 � �(1)=1 � BlockDrop : sx=2 � 0,x �D 3+50,y �D 3+67,0 �  .KeyRead � 0 � �� � 15,4 char$=� � char$=܆(31)   xc-1 : change=1 : delete=0   � xc<0 �! xc=0   � �(97) �! xc=0   � MoveSprite �� � char$=܆(30)   xc+1 : change=1 : delete=0   � xc>4 �! xc=4   � �(97) �! xc=4   � MoveSprite �� � char$=܆(28)   yc-1 : change=1 : delete=0   � yc<0 �! yc=0   � �(97) �! yc=0   � MoveSprite �� � char$=܆(29)   yc+1 : change=1 : delete=0   � yc>12 �! yc=12   � �(97) �! yc=12   � MoveSprite �� � drawblock>30 �B drawblock<52   extrablock=drawblock �"   extrablock=0 �� � change �! � ShowBlock : change=0 � char$="-"   lvl-1   � lvl<0 �! lvl=31   � BlitIt   � ShowLevel �� � char$="="   lvl+1   � lvl>31 �! lvl=0   � BlitIt   � ShowLevel �� � char$="[" �! bckgrnd-2 : � BackBlock : � ShowLevel � char$="]" �! bckgrnd+2 : � BackBlock : � ShowLevel � char$=܆(127) �! delete=1-delete : � ShowBlock � char$="c" �! � ClearLevel : � BackBlock : � Background � char$="l"   � ��   btext=1 : � BlitIt : �6 : � LoadMap : btext=0   �7 150 : �4 : � 0 : � ShowLevel �� � char$="s"   � ��   btext=2 : � BlitIt : � FillIn : � BlockCount   �6 : � SaveMap : btext=0   �7 250 : �4 : � 0 �� � char$="t" �! � Time : � FillIn � char$="b" �! lvbnk+1 : � LevelBankPrint � char$="C"   btext=3 : � BlitIt : � ClearMap : � 0   � ShowLevel : btext=0 �� � char$="e" �! extras=1-extras : soep=1 : � ShowLevel : soep=0 �  .BlockHits: hitsnr=1 � drawblock=30 �! hitsnr=2 � drawblock=61 �! hitsnr=3 � drawblock=62 �! hitsnr=3 � drawblock=63 �! hitsnr=4 �  .BlockScore: score=5 � drawblock>14 �! � drawblock<30 �! score=10 � drawblock=30 �! score=20 � drawblock=52 �! score=15 � drawblock=53 �! score=15 � drawblock=54 �! score=10 � drawblock>30 �! � drawblock<52 �! score=20 � drawblock=55 �! score=30 � drawblock=56 �! score=15 � drawblock=57 �! score=20 � drawblock=58 �! score=15 � drawblock=59 �! score=15 � drawblock=60 �! score=10 � drawblock=61 �! score=20 � drawblock=62 �! score=20 � drawblock=63 �! score=25 �  .FillIn: � playtime<3 �! playtime=18 info(lvl)\points=playtime �  .Time: sec1+3 � sec1 > 126   sec1=121   min2+1 �� � min2 =126 �! � sec1>121 �! sec1=124 : min2=121 � min2 > 126 �! min2=121 : sec1=124 playtime=((sec1-121)+(6*(min2-121))) : � FillIn �  .BlockDrop: � delete   � level(lvl,x,y)\lr=1     � x �B 1       � bckgrnd+1,x �D 3+50,y �D 3+67       � bckgrnd,x �D 3+58,y �D 3+67     �"       � bckgrnd,x �D 3+50,y �D 3+67       � bckgrnd+1,x �D 3+58,y �D 3+67     ��   �� �"   � level(lvl,x,y)\lr=0     � level(lvl,x+1,y)\lr=0       � extrablock=0         � drawblock,x �D 3+50,y �D 3+67       ��     ��   �"     � level(lvl,x,y)\lr=1 �! � level(lvl,x,y)\blocknr<>64       � info(lvl)\extra<maxextras         � drawblock,x �D 3+50,y �D 3+67       �"         � extrablock=0           � drawblock,x �D 3+50,y �D 3+67         ��       ��     ��   �� �� � t=0 � 1   � delete     � level(lvl,x,y)\lr=1       � level(lvl,x+t,y)\extra>0         � t=0 �! info(lvl)\extra-1       ��       � soup=0 � 1       level(lvl,x+soup,y)\blocknr=0,0,0,0,0       � soup     ��   �"     � extrablock>0       � info(lvl)\extra < maxextras         � level(lvl,x,y)\lr=1 �! � level(lvl,x,y)\extra=0 �! � level(lvl,x,y)\blocknr<>64           � soup=0 � 1           level(lvl,x+soup,y)\extra=extrablock           � soup           � t=0 �! info(lvl)\extra+1         ��       �" info(lvl)\extra=maxextras       ��     �"       � level(lvl,x,y)\lr<>2 �! � level(lvl,x+1,y)\lr<>1         � soup=0 � 1         level(lvl,x+soup,y)\lr=1+soup         level(lvl,x+soup,y)\blocknr=drawblock         level(lvl,x+soup,y)\hits=hitsnr         level(lvl,x+soup,y)\points=score         � soup         � level(lvl,x,y)\extra<>0           � t=0 �! info(lvl)\extra=-1           level(lvl,x+t,y)\extra=0         ��       ��     ��   �� � t �  .BackBlock � bckgrnd<65 �! bckgrnd=85 � bckgrnd>85 �! bckgrnd=65 info(lvl)\blocknr=bckgrnd �  .ShowBlock � delete   � bckgrnd,296,73 : � bckgrnd+1,304,73 �" � drawblock,296,73 �� �  .BackBlockPrint bckgrnd=info(lvl)\blocknr � bckgrnd<65 �� bckgrnd>85 �! bckgrnd=65 �  .Background: � lvl<0 �! lvl=31 � lvl>31 �! lvl=0 bckgrnd=info(lvl)\blocknr � bckgrnd=0 �! info(lvl)\blocknr=65 : bckgrnd=65 � yz=19 � 240 � 8   � xz=2 � 210 � 16     � bckgrnd,xz,yz     � bckgrnd+1,xz+8,yz   � xz � yz �  .ShowLevel � soep=0 �! � Background xz=0 : yz=0 � yzs=67 � 187 � 8   � xzs=50 � 170 � 8     � level(lvl,xz,yz)\lr=1       � level(lvl,xz,yz)\blocknr,xzs,yzs       � extras         � level(lvl,xz,yz)\extra>0           � level(lvl,xz,yz)\extra,xzs,yzs         ��       ��       xzs+8:xz+1     ��     xz+1   � xzs   xz=0 : yz+1 � yzs � MapToTime � BackBlockPrint � BackBlock �  .ClearLevel � yz=0 � 15   � xz=0 � 15     level(lvl,xz,yz)\blocknr=0,0,0,0,0   � xz � yz   info(lvl)\blocknr=0   info(lvl)\points=3   info(lvl)\extra=0 �  .ClearMap � lvl=0 � 31   � ClearLevel � �  .BlockCount lvlmem=lvl � lvl=0 � 31   blockcount=0   � yz=0 � 15     � xz=0 � 15       � level(lvl,xz,yz)\lr=1 �! � level(lvl,xz,yz)\blocknr<>64       blockcount+level(lvl,xz,yz)\hits       xz+1       ��     � xz   � yz   info(lvl)\hits=blockcount � lvl lvl=lvlmem �  .LoadMap a$=drive$+"Custom"+݃(lvbnk) b$=drive$+"Custom"+݃(lvbnk)+"Info" � � (0,a$)   � �
(0)=size �! � 0,&level(0,0,0),size   � 0 �� � � (2,b$)   � �
(2)=infosize �! � 2,&info(0),infosize   � 2 �� �  .SaveMap a$=drive$+"Custom"+݃(lvbnk) b$=drive$+"Custom"+݃(lvbnk)+"Info" � � (1,a$)   � 1,&level(0,0,0),size : � 1 �� � � (3,b$)   � 3,&info(0),infosize : � 3 �� �  .LevelBankPrint: � lvbnk>3 �! lvbnk=1 �  blockdata: � 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24 � 25,26,27,28,29,30,61,62,63,64,52,53,54,56,55,57,58,59,60,31,32,33,34,35,36 � 37,38,39,40,41,42,43,44,45,46,47,48,49,50,51  .PrintBlocks: �� blockdata � xw=0 � 4   � bl   � bl,xw �D 4+232,108   BlockMap(xw,0)=bl � xw � xw=0 � 4   � bl   � bl,xw �D 4+232,116   BlockMap(xw,1)=bl � xw � xw=0 � 4   � bl   � bl,xw �D 4+232,124   BlockMap(xw,2)=bl � xw � xw=0 � 4   � bl   � bl,xw �D 4+232,132   BlockMap(xw,3)=bl � xw � xw=0 � 4   � bl   � bl,xw �D 4+232,140   BlockMap(xw,4)=bl � xw � xw=0 � 4   � bl   � bl,xw �D 4+232,148   BlockMap(xw,5)=bl � xw � xw=0 � 4   � bl   � bl,xw �D 4+232,156   BlockMap(xw,6)=bl � xw � xw=0 � 4   � bl   � bl,xw �D 4 +232,164   BlockMap(xw,7)=bl � xw � xw=0 � 4   � bl   � bl,xw �D 4+232,172   BlockMap(xw,8)=bl � xw � xw=0 � 4   � bl   � bl,xw �D 4+232,180   BlockMap(xw,9)=bl � xw � xw=0 � 4   � bl   � bl,xw �D 4+232,188   BlockMap(xw,10)=bl � xw � xw=0 � 4   � bl   � bl,xw �D 4+232,196   BlockMap(xw,11)=bl � xw � xw=0 � 4   � bl   � bl,xw �D 4+232,204   BlockMap(xw,12)=bl � xw �  .MoveSprite: � 0,xc �D 4+232,yc �D 3+108,4 drawblock=BlockMap(xc,yc) � BlockScore � 