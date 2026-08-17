> Yeah, well... I'm gonna go build my own theme park, with blackjack and hookers.

(c) Bender Bending Rodríguez

![Telegraher](/TMessagesProj/src/main/res/mipmap-xhdpi/ic_launcher.png)

## Telegraher

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
* i cloned the latest `master` branch (with 8.3.1 patch) into `master_8.3.1`
    * actually master branch for repo is `graher_12.92.1`
* i made another branch `noshit_8.3.1` from `master_8.3.1`, it contain changes

It gives us `telegram` -> `master` -> `master_8.3.1` -> `noshit_8.3.1`

So **all the code changes** are in `noshit_8.3.1` (when this project started, actual version is
different)

### Summary

There are old README from [8.3](README_old_8.3.1.md) and from 2023th [9.33](README_old_9.33.md).

Latest release is [HERE](https://github.com/nikitasius/Telegraher/releases/latest) on this GITHUB

Actual graher is simplified, also it's acutually not FOSS. Maybe we'll make it foss + add more features.

* DISABLED ADS
* EVERY element have `save to downloads`/`save to gallery`
* DISABLED REMOTE DELETIONS
* FULL ACCESS in "restrict saving content" chats
* FULL ACCESS in secret chats (GREEN ONES!)
* KEEP CACHED chats while banned in
* DISABLED emulator detections
* LEGIT Phone and legit SIM no matter which number you use
* Scramble PIN layout to make your PIN undetectable for CCTV footages
* in progress: "Making it foss 4/6" (removed google billing & tg, removed fcm trackers)
* Hi, i'm Vanilla telegram using vanilla keys, vanilla fingerpring & package 💅

Another features (timed TTL messages etc) need to me moved.

### BUILD

1) You clone the project on your dev laptop or a pc.
2) You run `gradle :TMessagesProj_AppStandalone:assembleStandalone` OR click in your IDE `TMessagesProj_AppStandalone -> assembleStandalone`
3) It will assemble for you APK and sign w/ default keys

You can still use docker TG offer for official build, just build a **Standalone** app


### APKs

* for android >=5
* Realeases are
  here: [https://github.com/nikitasius/Telegraher/releases](https://github.com/nikitasius/Telegraher/releases)
    * if it contain `beta` it mean it's BETA
* Last beta: write `!beta` in chat

### Issues/Wishlist

Feel free to use the "issues section". I'm not an Android programmer, i'm a Java developper.
Probably it's a good thing 😃

### [Changes](README_CHANGES.md)

### Code mirrors

# NEED TO UPDATE / 2026 / OUTDATED except telegram channel

* Github: [https://github.com/nikitasius/Telegraher](https://github.com/nikitasius/Telegraher)
* Gitlab: [https://gitlab.com/nikitasius/Telegraher](https://gitlab.com/nikitasius/Telegraher)
    * autosync from github
* HTTPS: [https://git.evildayz.com/Telegraher/](https://git.evildayz.com/Telegraher/)
    * manually sync (add a script later 😀)
    * `releases` w/ actual releases and cloned `Telegraher` & `Telegraher.git` in `.tar.gz`
    * `betas` w/ actual betas
* TG channel: [https://t.me/telegraher](https://t.me/telegraher)

### Coffee

* Here is my [PayPal](https://paypal.me/nikitasius) `https://paypal.me/nikitasius`
* Here is
  my [BTC](bitcoin:bc1q5egmj6vjejmsu4lu3nmdshvx6p0kcajlw5u9a0?message=github_telegraher) `bc1q5egmj6vjejmsu4lu3nmdshvx6p0kcajlw5u9a0`
* Here is
  my [Yoomoney](https://yoomoney.ru/to/410015481871381) `https://yoomoney.ru/to/410015481871381`

> In fact, forget the park!
