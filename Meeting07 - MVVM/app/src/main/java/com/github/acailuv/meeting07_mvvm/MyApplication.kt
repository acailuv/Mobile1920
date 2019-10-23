package com.github.acailuv.meeting07_mvvm

import android.app.Application
import timber.log.Timber

class MyApplication: Application() {

    companion object {
        // Constants
        val MAIN_MENU = "Main Menu"
        val TRY_AGAIN = "Try Again"
        val CONTINUE = "Continue"

        // Scenes
        val scenes: List<Scene> = listOf (
            // 0
            Scene(
                "Introduction",
                "You are an experienced paladin wielding a broadsword and a shield to fight in the name of the light. " +
                        "'Lightborne' is the name of your faction. The opposing faction 'Darkborne' is trying to steal your sword " +
                        "and shield since it is a relic that prevents the Darkborne faction from ruling the world. Your relic is not " +
                        "the only thing that they are after, though. A young woman that you will encounter later possesses the power of " +
                        "the goddess but in its rawest form. If the Darkborne faction can get a hold of her, they can rule the world without " +
                        "taking away your relic.",
                actions = listOf(
                    "Select One ...",
                    "... Of These ...",
                    "... Options and click 'Action!' ...",
                    "... To continue."
                )
            ),

            // 1
            Scene(
                "The Fateful Encounter",
                "A sunny day. You are walking through a breezy woods. Everything is peaceful until you are attacked from behind. The strike " +
                        "wasn't really that powerful compared to your strength. You easily blocked the sword slash that someone made from behind with your shield. " +
                        "You turned around and you see a group of people. Two people to be exact. The person that attacked you is a young man with black hair and rugged " +
                        "face as if he was just attacked, and the other person is a girl with pink hair, she seems scared and hesitant as if she do not want to attack you " +
                        "in the first place. \"J-j-just hand me your stuff, right now!\" the young man said to you.",
                actions = listOf(
                    "Ask why they are doing this? They look like good people.",
                    "\"Try that again, and you are dead meat.\"",
                    "Walk away",
                    "Give them some of your gold, you have a ton of them at your mansion anyways."
                )
            ),

            // 2
            Scene(
                "Fateful Encounter: Honesty",
                "The trembling grip of the person that attacked you grows stronger. He lets down his sword and tells you the truth: \"Ahhh, what's the point? " +
                        "This idea truly is a bad one.\" He puts his sword on his back into the scabbard, \"I am sorry. I am only doing this because a group of thieves " +
                        "attacked our small guild for three days in a row now. We don't even have a piece of bread to eat anymore. They took everything!\"",
                actions = listOf(
                    "Offer them your assistance.",
                    "Leave",
                    "",
                    ""
                )
            ),

            // 3
            Scene(
                "Fateful Encounter: Intimidation",
                "\"Tch, you veterans are all the same. You always see us low-ranks like pieces of garbage!\" He lets down his sword and tells you the truth: \"Ahhh, what's the point? " +
                        "This idea truly is a bad one.\" He puts his sword on his back into the scabbard, \"I am sorry. I am only doing this because a group of thieves " +
                        "attacked our small guild for three days in a row now. We don't even have a piece of bread to eat anymore. They took everything!\"",
                actions = listOf(
                    "Offer them your assistance.",
                    "Leave",
                    "",
                    ""
                )
            ),

            // 4
            Scene(
                "Fateful Encounter: Cold",
                "As you leave the area without saying a single word, you can hear them talking about what a bad idea it was to attack you. " +
                        "The young man tells the girl that he doesn't have a choice, if he does not get some gold until sunset, they won't have anything to " +
                        "eat. You stopped walking and think about their conditions for a little bit.",
                actions = listOf(
                    "Offer them your assistance.",
                    "Leave",
                    "",
                    ""
                )
            ),

            // 5
            Scene(
                "Fateful Encounter: Generosity",
                "You take a bulging gold pouch that magically rests on the bag on your back and give it to them. He walks slowly towards you. He reaches the gold pouch and before he can take it, " +
                        "You tighten the grip of your hand. You want to know why they are doing this, they do not seem like bad people. So, you asked them right away. The trembling grip of the person that " +
                        "attacked you grows stronger. He lets down his sword and tells you the truth: \"Ahhh, what's the point? " +
                        "This idea truly is a bad one.\" He puts his sword on his back into the scabbard, \"I am sorry. I am only doing this because a group of thieves " +
                        "attacked our small guild for three days in a row now. We don't even have a piece of bread to eat anymore. They took everything!\"",
                actions = listOf(
                    "Offer them your assistance.",
                    "Leave",
                    "",
                    ""
                )
            ),

            // 6
            Scene(
                "Strong Enough to Handle Things Alone",
                "You offered them your assistance in fending off these 'thieves'. " +
                        "The young man declined your offer, \"I am strong enough to handle things on my own. I do not need your pity.\" " +
                        "Respecting the man's passionate decision, you leave him alone. You inspect the mark he had received from the thieves on " +
                        "his right hand and realized that the 'thieves' are a group of powerful people and not some common rascals. You ask them to take one of your [Beacon Crystal] " +
                        "to notify you just in case they needed help when the thieves come. The young swordsman reluctantly accepts your offer and leave. The pink-haired girl " +
                        "bowed to you and give her thanks for your generous help.",
                actions = listOf(
                    CONTINUE,
                    "",
                    "",
                    ""
                )
            ),

            // 7 -- badEnding1
            Scene(
                "Bad Ending: You left",
                "You left them alone. End of story.",
                actions = listOf(
                    MAIN_MENU,
                    TRY_AGAIN,
                    "",
                    ""
                )
            ),

            // 8
            Scene(
                "Guild in Distress!",
                "It has been several days since your last encounter with the little 'bandits', you are starting to wonder " +
                        "how they fare. You are currently fighting a enormous beast of half man and half bull - a minotaur. Since you are " +
                        "a 'tank' class (meaning that you have a lot of strength and perseverance to take hits), you don't have that much " +
                        "power in terms of offensive power, \"*sigh* this is going to take a while.\" You said to yourself as you land tiny " +
                        "cuts at the minotaur hoping that the beast would fell before sunset.\n\nThe sun is setting, the beast you are fighting has grown frail " +
                        "from the shallow cuts you inflict. A little more time and you will get the monster's loots! However, you sense that the [Beacon Crystal] you " +
                        "gave to the poor people several days ago has been activated.",
                actions = listOf(
                    "Teleport to the [Beacon Crystal] right away!",
                    "Maybe after I finish this 13 hours fight?",
                    "Ignore it, I'm not going to waste this fight for some random signal of distress.",
                    ""
                )
            ),

            // 9
            Scene(
                "Heroic Comeuppance!",
                "You teleported to the source of the [Beacon Crystal] right away! Right when you get there, a swing of a dagger is on its way to you. You parry it with ease, " +
                        "but you know that the technique of the strike was not a flimsy one. To your back is the black haired man and the pink haired girl from before. The [Beacon " +
                        "Crystal] has been crushed next to them, that explains why you got the signal. \"Is it you? Are you the one who robbed these poor souls for 3 nights in a row? Have you " +
                        "no shame? These people have nothing already, leave them be!\" You said to the thieves in front of you. One of the thieves that appears to be the leader of the pack " +
                        "take a step forward swipe his nose with the back of his hand and said, \"Okay, okay. I see you are a paladin from Lightborne aren't ye? I don't want any trouble, so " +
                        "just hand me those [Construction Cubes] so that we can build our base.\"",
                actions = listOf(
                    "\"Are you insane? You robbed these people non stop and you want to take those rare items too?! I won't let that happen!\"",
                    "Give them the small guild's [Construction Cubes]",
                    "Give them YOUR [Construction Cubes]",
                    ""
                )
            ),

            // 10 -- badEnding2
            Scene(
                "Bad Ending: You Ignored Them?!",
                "I don't know what you are thinking! You are the main hero of this story for crying out loud. How could you do something so... " +
                        "unheroic. Even if you change your mind right now, it will be too late.",
                actions = listOf(
                    MAIN_MENU,
                    TRY_AGAIN,
                    "",
                    ""
                )
            ),

            // 11
            Scene(
                "Goddess' Servant's Protection",
                "The thieves' leader puts a smug on his face, \"C'mon mister paladin guy, there are five of us and one of you. Do you really think you can defeat us all?\" " +
                        "You pull your sword from your shield where it rests and point it at the leader.\n\nThe thieves pounced at you at the same time, you successfully blocked all of their attacks by " +
                        "putting your shield in front of you. You swing your sword at the thieves' direction and they are just too quick for you to score a strike. Realizing this, you casted a spell " +
                        "[Valley of Guilt] that continuously drains the stamina of those who has a vile intent against you. That way, you can slow them down without hurting the black haired man and " +
                        "the pink haired girl.\n\nYou and the thieves has been at it for several minutes now, trading blows and cuts. The thieves are slowing down, it seems like your spell works. " +
                        "They are finally slow enough for you to effectively attack. You noticed that every single one of those thieves wear a [Revival Necklace] meaning that they will be revived " +
                        "every time they are killed (or knocked out cold) as long as the [Revival Core] at their base is intact. They will drop their current belongings, though. " +
                        "You can make lethal strikes and kill them at the spot or you can knock them all out with your shield.",
                actions = listOf(
                    "Go for blood, death is the only thing they deserve.",
                    "Mercifully knock them all out.",
                    "",
                    ""
                )
            ),

            // 12
            Scene(
                "Peace Treaty (Guild's Cubes)",
                "You take the burlap sack containing the [Construction Cubes] behind you and give them to the thieves, \"Here, now leave and do not disturb this guild ever again!\" As agreed upon " +
                        "the thieves throw some smoke bombs to the ground and disappear.\n\n\"What are you thinking?! Giving OUR cubes to those bastards!\" The black haired swordsman yelled at you. You " +
                        "explained that you cannot take the risk of accidentally striking him and the pink haired girl if a fight indeed broke out. The swordsman won't listen to you, but the girl values " +
                        "your sympathy.",
                actions = listOf(
                    CONTINUE,
                    "",
                    "",
                    ""
                )
            ),

            // 13
            Scene(
                "Peace Treaty (Your Cubes)",
                "Since you don't have a guild of your own (faction is not the same as guild), you decided to hand the thieves your [Construction Cubes]. You put the cubes out of your magical bag on your " +
                        "back and hand them over to the thieves, \"There, just don;t ever come back here again. It shall be a different story next time I see your kind here.\" The thieves' leader chuckled and " +
                        "takes the cubes out of your hand. The thieves leaves afterwards.\n\nThe black haired swordsman seems disappointed because you did not teach the thieves' a lesson, but the girl is " +
                        "grateful for what you have done.",
                actions = listOf(
                    CONTINUE,
                    "",
                    "",
                    ""
                )
            ),

            // 14
            Scene(
                "Goddess' Servant's Protection: Blood",
                "You relentlessly butchered them all. They disperse into a glowing mist and left behind their belongings, they will respawn at their base but this will surely teach them a lesson. " +
                        "You look back over your shoulders and you can see the black haired swordsman is looking at you with relief and satisfaction. But you could see tears gathering at the side of the " +
                        "pink haired girl as she looks at your blood-covered armor in fear and disdain.",
                actions = listOf(
                    CONTINUE,
                    "",
                    "",
                    ""
                )
            ),

            // 15
            Scene(
                "Goddess' Servant's Protection: Mercy",
                "They keep on coming to you, but you blocked their attacks and counter them with a powerful bash from your shield. One after the other they fall to the ground and disperse into " +
                        "a glowing mist and left behind their belongings, they will respawn at their base but this will surely teach them a lesson. You look back over your shoulders and you can see the black " +
                        "haired swordsman is looking at you with relief and satisfaction. The pink haired girl is also looks at your with a cheerful gaze as if she is celebrating your victory inside.",
                actions = listOf(
                    CONTINUE,
                    "",
                    "",
                    ""
                )
            ),

            // 16
            Scene(
                "Crackling Fire Inside The Guild's Ruins",
                "Inside the guild's ransacked gathering hall, you and the two guild members make a fire to fight the night's cold " +
                        "breeze. They introduced themselves, the black haired swordsman is called Leon and the pink haired girl is called Kaya. " +
                        "They are planning to go to a undead dungeon tomorrow and is wondering if you want to accompany them. You do not have " +
                        "anything to do anyways so you agreed to accompany them. the atmosphere seems peaceful but deep inside you know something " +
                        "bad will happen tomorrow.\n\nLeon asked you why you helped them.",
                actions = listOf(
                    "Tell the truth.",
                    "Prefer not to talk about it.",
                    "",
                    ""
                )
            ),

            // 17
            Scene(
                "Silenced Tears",
                "You prefer not to talk about it. You and the tiny guild spend the rest of the night in silence.",
                actions = listOf(
                    CONTINUE,
                    "",
                    "",
                    ""
                )
            ),

            // 18
            Scene(
                "A Disappointing Past",
                "You spill the beans. You said that you are helping the Leon's guild because you could not protect your own. " +
                        "Several years ago, you are a leader of a guild, and a group of thieves from the same faction as the one that attacked Leon's guild " +
                        "earlier successfully demolished and robbed your guild. Every member of your guild was killed and they cannot be revived because you do not have " +
                        "enough [Construction Cubes] to make a [Revival Core].\n\nLeon values your honesty.\nKaya cheers you up by saying you are now strong enough to " +
                        "save her guild from the same people.\n\nYou spend the rest of the night talking about each other's past with the other guild " +
                        "members.",
                actions = listOf(
                    CONTINUE,
                    "",
                    "",
                    ""
                )
            ),


            // 19
            Scene(
                "At Danger's Door",
                "You arrived at the undead dungeon the next day. It is a cave in the middle of the forest. Being a paladin, you can smell the " +
                        "unholy stench from a mile away. Leon and Kaya seems enthusiastic and eager to proceed. You carefully march onward with them. ",
                actions = listOf(
                    CONTINUE,
                    "",
                    "",
                    ""
                )
            ),

            // 20
            Scene(
                "Darkborne's Presence",
                "You and the guild has cleared several waves of undead with ease, but you sense the presence of the utmost evil around you somewhere. " +
                        "It's none other than the dark acolytes of Darkborne. You asked Leon and Kaya to stop and stand back. Confused by your actions, Leon " +
                        "asked if there's anything wrong.",
                actions = listOf(
                    "Tell them there are Dark Acolytes from the Darkborne faction trying to attack us.",
                    "\"It's better for you to not know\"",
                    "",
                    ""
                )
            ),

            // 21
            Scene(
                "Dark Acolyte Assailants!",
                "You tell Leon to be careful because there are powerful dark acolytes ready to attack you, Leon, and Kaya at anytime. The cave " +
                        "is not really well lit, so Leon and Kaya's vision is not that good, but your senses are reinforced by years of experience.",
                actions = listOf(
                    CONTINUE, // GOTO 23
                    "",
                    "",
                    ""
                )
            ),

            // 22
            Scene(
                "Do Not Panic!",
                "You tell Leon that there is nothing to worry about, but just stay on guard for a bit. Leon can sense that you are hiding something " +
                        "from him and he is a little disappointed in you because he do not like to be treated like a powerless liability.",
                actions = listOf(
                    CONTINUE, // GOTO 23 (-leon)
                    "",
                    "",
                    ""
                )
            ),

            // 23
            Scene(
                "Final Encounter: Part One",
                "From beyond the shadows four hooded figures walks slowly towards you. \"Ah, THE Lightborne paladin is here. In this cramped place, " +
                        "perfect for an ambush like this. Now, give us your relic-\" One of the dark acolytes stops talking for a moment, " +
                        "\"T-The fading power of the goddess...\" one of the dark acolytes said while pointing his crooked index finger towards Kaya. " +
                        "\"If we could get our hands on her, your relic is as good as a piece of garbage! Darkborne shall make this world our slave!\" The " +
                        "dark acolyte continues and laughs hysterically. The four dark acolytes start chanting an incantation to cast a powerful spell. " +
                        "glowing purple hexagram sigil is forming in front of them, they are planning to blast you with a beam of unholy energy. \"If we could " +
                        "get rid of you first, then we can take the girl!\"\n\nKaya looks at you with a puzzled eyes and said, \"Is that true? Is it true " +
                        "that they will enslave the world if they manage to get a hold of me?\" You have no choice but to nod and say that it's true. She " +
                        "pulls your armor and ask you to protect her.",
                actions = listOf(
                    "Prepare for Impact!", //GOTO 24
                    "",
                    "",
                    ""
                )
            ),

            // 24
            Scene(
                "Final Encounter: Part Two",
                "You prepared for impact. You put your shield in front of you, guarding Leon and Kaya. The incantation is complete, there is a moment of silence.\n\n" +
                        "Then in an instant you feel a powerful impact striking your shield, you can barely hold the impact you just received. You sheathe your sword back to your shield and " +
                        "your shield shines brightly. You can feel the impact is much lighter than before. However, just when you think you can block this attack, a burst " +
                        "of energy knock the relic out of your hand to the back of the cave room, near Leon.\n\nLeon and Kaya is extremely frightened of what just " +
                        "happened.",
                actions = listOf(
                    "Ask Leon to take the shield and throw it to you.",
                    "",
                    "",
                    ""
                )
            ),

            // 25
            Scene(
                "Final Encounter: Part Two (Leon Escaped)",
                "Leon values his life more than your relic. He escaped the scene. The dark acolytes don't seem to be interested in him. However, they " +
                        "do not want any witnesses so they brutally murdered him, folding Leon inside out with the powers of dark magic.\n\nKaya's willpower is " +
                        "greatly shaken!",
                actions = listOf(
                    "Take the relic yourself while keeping Kaya behind you.", //GOTO 28
                    "",
                    "",
                    ""
                )
            ),

            // 26
            Scene(
                "Final Encounter: Part Two (Leon Obeys)",
                "Leon throws your sword and shield relic back at you. You swiftly put it back on your left forearm and ready yourself for another attack.",
                actions = listOf(
                    CONTINUE, //GOTO 27
                    "",
                    "",
                    ""
                )
            ),

            // 27
            Scene(
                "Final Encounter: Part Three",
                "The dark acolytes casted a shadow energy ball and throw it at you. It looks small but when it touches your shield you can feel the " +
                        "force shattered your forearm's bones. You are thrown away to the side of the cave room. You stood up and get in position again " +
                        "you tell Kaya and Leon to get out of here. You decided to buy some time for their escape.",
                actions = listOf(
                    CONTINUE, //GOTO 31
                    "",
                    "",
                    ""
                )
            ),

            // 28
            Scene(
                "Final Encounter: Part Three",
                "The dark acolytes manage to get a hold of Kaya and they are trying to escape. They opened a portal to their base. It all happens so quickly that " +
                        "you have only little time to react. Everything went silent in your mind, you cannot even process sound and everything around you moves in slow motion. " +
                        "You can see tears falling from " +
                        "Kaya's eyes and you can read what her lips are saying: \"Please, don't let them have me. I don't want this world to be consumed by darkness.\"",
                actions = listOf(
                    "Throw your sword to kill Kaya and ruin Darkborne's plan.", // NORMAL ENDING (GOTO 30)
                    "Let Kaya live with the cost of the world enslavement.", // BAD ENDING 3 (GOTO 29)
                    "",
                    ""
                )
            ),

            // 29
            Scene(
                "Bad Ending: World Enslavement", // Bad Ending 3
                "You let the dark acolytes have Kaya and shortly after that, the world world kneel under its power.",
                actions = listOf(
                    MAIN_MENU,
                    TRY_AGAIN,
                    "",
                    ""
                )
            ),

            // 30
            Scene(
                "Normal Ending: Peace?", // Normal Ending 1
                "You threw your sword at Kaya. it pierces through her heart and she dies almost instantly as she is sucked by the dark acolytes' portal. Your sword then magically reappear inside " +
                        "its sheathe in your shield. Kaya is dead, but... at least the world is at peace. For now.",
                actions = listOf(
                    MAIN_MENU,
                    TRY_AGAIN,
                    "",
                    ""
                )
            ),

            // 31
            Scene(
                "Final Encounter: Part Four",
                "Leon tells Kaya that they should get out as fast as they can but Kaya do not want to leave you alone to die. " +
                        "You are constantly attacked by tons of dark energy projectiles and you keep blocking them to ensure Leon and Kaya's safety. " +
                        "Leon dragged Kaya slowly as you fight for their lives.",
                actions = listOf(
                    "Persevere...", //GOTO 32
                    "",
                    "",
                    ""
                )
            ),

            // 32
            Scene(
                "Final Encounter: Part Five",
                "Kaya screamed your name as she is forced to leave you. You are still being stormed by countless projectiles. You stand still to ensure " +
                        "their safety.",
                actions = listOf(
                    "Persevere...", // IF KAYA >= 3 GOTO 36 ELSE GOTO 33
                    "",
                    "",
                    ""
                )
            ),

            // 33
            Scene(
                "Goddess' Heir Safety",
                "As you hold the endless barrage of dark energy, you take a peek over your shoulder. You do not see any signs of Leon and Kaya. You sighed " +
                        "in relief and the barrage finally stops. One of the dark acolytes said, \"If we cannot have her, we can take away your relic.\"",
                actions = listOf(
                    "Surrender your relic.", //GOTO 34
                    "\"If I'm going to die, my relic comes with me.\"", //GOTO 35
                    "",
                    ""
                )
            ),

            // 34
            Scene(
                "Bad Ending: World Enslavement II", // Bad Ending 4
                "You let the dark acolytes have your relic and shortly after that, the world world kneel under its power.",
                actions = listOf(
                    MAIN_MENU,
                    TRY_AGAIN,
                    "",
                    ""
                )
            ),

            // 35
            Scene(
                "Normal Ending: Warrior of Light's Sacrifice", // Normal Ending 2
                "You casted a spell [Goddess' Final Judgement] to let out a destructive blast that obliterates everyone in that cave room with the " +
                        "power of light. " +
                        "Including you and your relic. But the world is at peace...",
                actions = listOf(
                    MAIN_MENU,
                    TRY_AGAIN,
                    "",
                    ""
                )
            ),

            // 36
            Scene(
                "Aid of The Goddess' Heir",
                "Just when Kaya leave the room a bright light is coming from her direction. Your wounds are instantly healed and you have found new " +
                        "strength within. The barrage of dark energy stopped instantly and the dark acolytes stood in disbelief. You stared at them and " +
                        "read them a few lines from the Goddess' Scripture as you walk forward.",
                actions = listOf(
                    "Smite those heathens in the name of the Goddess' Light!", //GOTO 37
                    "",
                    "",
                    ""
                )
            ),

            // 37
            Scene(
                "Best Ending: Happily Ever After", // Best Ending
                "You butchered the dark acolytes in that cave room and meet Leon and Kaya outside the cave. Kaya hugs you right away. She said that she " +
                        "is happy that you can make it out alive. They (including you) lived happily ever after.",
                actions = listOf(
                    MAIN_MENU,
                    TRY_AGAIN,
                    "",
                    ""
                )
            )

        )

        // Ending flags
        var badEnding1 = false
        var badEnding2 = false
        var badEnding3 = false
        var badEnding4 = false
        var normalEnding1 = false
        var normalEnding2 = false
        var bestEnding = false

        // Timber Prefix (for grading purposes to make my logging more visible and easily filtered).
        // I made this because I thought it would be a difficult to see my logs.
        // Feel free to change this bit to suit your needs.
        var LOG_PREFIX = "[TIMBER LOGGING] -------------> "

        // Timber Message Constants
        var ON_CREATE_CALLED = LOG_PREFIX + "onCreate() Called!"
        var ON_START_CALLED = LOG_PREFIX + "onStart() Called!"
        var ON_RESUME_CALLED = LOG_PREFIX + "onResume() Called!"
        var ON_PAUSE_CALLED = LOG_PREFIX + "onPause() Called!"
        var ON_STOP_CALLED = LOG_PREFIX + "onStop() Called!"
        var ON_DESTROY_CALLED = LOG_PREFIX + "onDestroy() Called!"
        var ON_RESTART_CALLED = LOG_PREFIX + "onRestart() Called!"
        var ON_ATTACH_CALLED = LOG_PREFIX + "onAttach() Called!"
        var ON_DETACH_CALLED = LOG_PREFIX + "onDetach() Called!"
        var ON_CREATE_VIEW_CALLED = LOG_PREFIX + "onCreateView() Called!"
        var ON_DESTROY_VIEW_CALLED = LOG_PREFIX + "onDestroyView() Called!"

        // Utils
        lateinit var currentDisplayedEnding: Scene
    }

    override fun onCreate() {
        super.onCreate()

//        if (BuildConfig.DEBUG) {
//            Timber.plant(Timber.DebugTree())
//        }

        Timber.plant(Timber.DebugTree())
    }
}