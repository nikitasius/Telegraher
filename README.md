> Yeah, well... I'm gonna go build my own theme park, with blackjack and hookers.

(c) Bender Bending Rodríguez

![Telegraher](/TMessagesProj/src/main/res/mipmap-xhdpi/ic_launcher.png)

## Telegraher

> 3rd generation

![Telegraher](/telegraher.512px.png)

* **No one gets to decide** what i run on my device
* **No one gets to decide** where i run my app
* **No one gets to decide** what must be deleted

> This is my device so i control it 😎

> This app have nothing with privacy, it's remotely controlled. It's pissing me off, so i changed
> that.

> I took an original Telegram client from ["official" repo](https://github.com/DrKLO/Telegram) and
> made my own theme park with blackjack and hoookers.

**Special thanks**:

* my wife and my dog, love them 🍑
* mr Rodríguez for the inspiration
* some anonymous folks over the telegram for the great ideas (can't share their names here, cause
  they are anonymous)
* "Telegram🦄magic🦄team" for their "magic🦄updates" including ~~private~~ chats and "magic🦄ads"

### WTF?! / is it legit?

Follow the ~~white rabbit~~ the git flow:

* i took and forked the original client
* i cloned the latest `master` branch (with a.b.c patch) into `master_a.b.c`
* i made another branch `graher_a.bc` from `master_a.b.c`, it contain the changes
    * actual master branch for repo is `graher_12.92.1` (YES it have to be `graher_12.92`)

It gives us `telegram` -> `master` -> `master_a.b.c` -> `graher_a.bc`

So **all the code changes** are in `graher_a.bc`

### Summary

This is a 3rd generation of Graher, a grand-kid whatever

ReadMe history:

* old README from [8.3](README_old_8.3.1.md)
* 2023th [9.33](README_old_9.33.md).
* 2026 pre-graher3 [12.92-old](README-pre-12.92.md).

### Latest release

It's [HERE](https://github.com/nikitasius/Telegraher/releases/latest) on this GITHUB

Actual graher is simplified, also it's acutually not FOSS. Maybe we'll make it foss + add more features.

* DISABLED ADS
    * funny moment i found a code for video ads. Will it be like on TV?
* EVERY element have `save to downloads`/`save to gallery`
* _almost_ DISABLED REMOTE DELETIONS (have to do some homework here)
* FULL ACCESS in "restrict saving content" chats
* FULL ACCESS in secret chats (GREEN ONES!)
* KEEP CACHED chats while banned in
* DISABLED emulator detections gives you LEGIT phone
* No SIM force TG send you code by mail/session/via SMS to avoid you sending the SMS (sometimes TG wanna force people to
  TYPE email and TYPE the CODE and SEND the SMS - thats bad behaviour and it happens on vanilla also)
* Removed trackers, google vision/login, it still contain some google libs like for FCM (need more cleaning but i doubt
  it will be 100% foss/floss/dentalfloss)
* Scramble PIN layout to make your PIN undetectable for CCTV footages (PLEASE USE IT!)
* PIN size can be between 4 and 16 digits you decice (and as vanilla it support raw passwords)
* Fingerprint/FaceID are disabled, so pigs won't use your hands/face to unlock graher
* Added Monet theme for android 12+ by @soyelmismo (github)
* Added the duress code to trigger KABOOM on your client (read more about duress
  idea [here](https://grapheneos.org/features#duress) on grapheneos website)
* Pin retry time reduced to 3 seconds, after 10 fails KABOOM
* Hi, i'm Vanilla telegram using vanilla keys, vanilla fingerpring & package 💅

### TODO

* Duress code
* TTL images
* device spoofing
* media quality boost

### BUILD

**If you're a dev**

1) You know what to do
2) Don't ask me bruh/sis/whatever
3) Or run `gradle :TMessagesProj_AppStandalone:assembleStandalone` OR click in your IDE
   `TMessagesProj_AppStandalone -> assembleStandalone`
4) It will assemble for you APK and sign w/ default keys

**If you're a donut**

1) Hey buddy, how are you?
2) Nice to see you!
3) You're so smart and clever if you're interrested in graher ❤️
4) You need to create a github account
5) Then you need to fork graher (graher it's a short of telegraher) using big white (or black) fork button
6) Then you can go to Actions where you click on `sudo bring me a beer`
7) Once you clicked, cause NO BEER = NO GRAHER, you have to click on `Run workflow`
8) `Graher version bruh` - any version, `Tell me bruh` - the text you wanna share on release, `Multipass?` here you pick
   `Multipass?`. If you pick `Korben Dallas` you won't board that spaceship!
9) It will work somehow around 40min or an 1h and build you your own babygraher 🎉

You can still use docker TG offer for official build, just build a **Standalone** app

### APKs

* for android >=5
* Realeases are
  here: [https://github.com/nikitasius/Telegraher/releases](https://github.com/nikitasius/Telegraher/releases)
    * if it contain `beta` it mean it's BETA
* To get help in chat write `!graher`

### Issues/Wishlist

Feel free to use the "issues section". I'm not an Android programmer, i'm a Java developper.
Probably it's a good thing 😃

### [Changes](README_CHANGES.md)

### Big thanks 🍻 :

* [xMAXIMx ](https://t.me/xMAXIMx) - chat bot maker, angry mod and support from 1-st days
* [fru2nyanya](https://t.me/fru2nyanya) - FAQ maker, user helper
* [redditOwner](https://t.me/redditOwner) - phone number supporter and extreme multiacc tester
* [Wolfsschanze44](https://t.me/Wolfsschanze44) - graher gen-2 notification icon designer
* [Scarlet4th](https://t.me/Scarlet4th) - chat keeper, english corrector
* [kolomviano](https://t.me/kolomviano) - making features and pushing PRs
* [scrizza](https://t.me/scrizza) - long time tester, extra fan (Humpee told that)
* ping [me](https://t.me/nikitasius) if i forgot someone

### Code mirrors

* Github: [https://github.com/nikitasius/Telegraher](https://github.com/nikitasius/Telegraher)
* Gitlab (**OUTDATED**): [https://gitlab.com/nikitasius/Telegraher](https://gitlab.com/nikitasius/Telegraher)
    * autosync from github is for prem only, have to build a CI/CD dammit!
* HTTPS (**OUTDATED**): [https://git.evildayz.com/Telegraher/](https://git.evildayz.com/Telegraher/)
    * manually sync (add a script later 😀)
    * `releases` w/ actual releases and cloned `Telegraher` & `Telegraher.git` in `.tar.gz`
    * `betas` w/ actual betas
* TG channel: [https://t.me/telegraher](https://t.me/telegraher)
* XDA thread: https://xdaforums.com/t/blackjack-and-hookers.4492879/

### Coffee

* Here is my [PayPal](https://paypal.me/nikitasius) `https://paypal.me/nikitasius`
* Cryptos
    * [BTC](bitcoin:bc1qhdxuuud5cy494m7s2gg3gy9pgz052wjtvrgu6m?message=github_telegraher)
      `bc1qhdxuuud5cy494m7s2gg3gy9pgz052wjtvrgu6m`
    * [XMR](monero:85jHELdPDbZSsJAUccud3aRmoF3oJszxCCJ3zEETM85AHeRfpEbQKnRFAkwHtdxfWhX5DaZf4v8NEGz6Wa6WHgQBGQXnYhr?message=github_telegraher)
      `85jHELdPDbZSsJAUccud3aRmoF3oJszxCCJ3zEETM85AHeRfpEbQKnRFAkwHtdxfWhX5DaZf4v8NEGz6Wa6WHgQBGQXnYhr` (best crypto
      ever, back in [old days](https://github.com/monero-project/monero/issues/6151))
    * [ETH](eth:0x00008672BC75707d897264a3dBB85036BCdE4CB3?message=github_telegraher)
      `0x00008672BC75707d897264a3dBB85036BCdE4CB3` and `USDT` on Ethereum
    * [SOL](solana:7ds9H5jFqnrZ1CemzDhqQnPvwiEuFVbW153bZihnF1dB?message=github_telegraher)
      `7ds9H5jFqnrZ1CemzDhqQnPvwiEuFVbW153bZihnF1dB` and `USDT` on Solana
* Here is
  my [Yoomoney](https://yoomoney.ru/to/410015481871381) `https://yoomoney.ru/to/410015481871381`

> In fact, forget the park!
