package com.github.acailuv.meeting03_loremgenerator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.github.acailuv.meeting03_loremgenerator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Declaring Ipsums
    private val loremIpsum: Ipsum = Ipsum("Lorem Ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec bibendum facilisis lacus id varius. Aenean lacinia tempor neque, id vulputate sem blandit ut. Suspendisse imperdiet lorem ante, sed finibus justo aliquam vel. Etiam iaculis orci enim, vel finibus justo consequat vitae. Maecenas tincidunt, felis sed feugiat accumsan, velit augue dictum orci, non venenatis turpis lorem id tortor. In elit sapien, ultricies vel cursus id, rutrum ut massa. Vestibulum congue consequat nunc, a bibendum justo malesuada a. Aenean eu ipsum sed sapien feugiat mattis ac ac neque. Nunc diam erat, varius vel nibh quis, tempor scelerisque enim. Ut faucibus sed urna eget vestibulum. Phasellus semper sed libero non cursus. Nam aliquam metus sed ipsum pellentesque, non lobortis risus aliquet. Sed at molestie elit.\n" +
            "Donec faucibus mauris facilisis velit euismod hendrerit. Interdum et malesuada fames ac ante ipsum primis in faucibus. Vivamus consectetur eget nisi nec suscipit. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Donec tincidunt, ligula vulputate ullamcorper cursus, est turpis tristique ex, non feugiat ipsum lorem quis augue. Nam ut faucibus risus. Pellentesque eget dictum lacus, vel cursus sapien.\n" +
            "Maecenas nec malesuada risus, a tincidunt dolor. Pellentesque vel tincidunt tellus. Mauris eu aliquam ligula. Nam sit amet justo eget neque tincidunt pellentesque. Nulla id accumsan tortor. Phasellus erat enim, convallis et leo et, pretium dapibus est. Fusce eget ipsum rutrum, finibus diam eget, cursus ante. Sed a metus auctor, rutrum lectus vitae, ullamcorper ex. Nullam sit amet tempor tortor, sed vestibulum mi. Cras efficitur ex quis vehicula aliquet. Sed pretium nisl lectus, nec posuere lacus iaculis at. Quisque ut orci eu leo eleifend pellentesque vel ut magna. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Sed eu vestibulum tortor. Vestibulum mollis id diam sit amet feugiat.\n" +
            "Nullam luctus purus id iaculis iaculis. Cras sed egestas lacus, eget pulvinar odio. Fusce non malesuada mi. Quisque pharetra commodo elit in vestibulum. Mauris at felis a enim venenatis mattis non eu arcu. Suspendisse potenti. Nulla ac nibh vitae quam placerat tempor vitae quis metus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Maecenas hendrerit lorem a purus malesuada hendrerit. Nam fringilla purus ac finibus interdum. Nulla quis massa in eros luctus ultrices quis eget lacus. Etiam quis arcu non odio condimentum pharetra. Ut in ultrices felis, nec accumsan arcu. Donec ante lorem, tempor eu elementum id, pellentesque vel arcu. Vestibulum id nisi sed libero suscipit venenatis. Curabitur mi lorem, rhoncus nec rutrum eu, gravida ac erat.\n" +
            "Maecenas luctus facilisis mauris, nec aliquam eros aliquet id. Proin quis tortor ac purus faucibus ullamcorper. Nam vel urna a nibh consectetur mollis. Morbi hendrerit purus sit amet massa volutpat condimentum. In vitae lorem metus. Vivamus condimentum ex viverra orci rutrum faucibus. Praesent ornare lobortis nunc, imperdiet mattis arcu bibendum vel.\n")
    private val cheeseIpsum: Ipsum = Ipsum("Cheese Ipsum", "I love cheese, especially goat macaroni cheese. Danish fontina pecorino bocconcini stinking bishop port-salut cheesy feet blue castello red leicester. Caerphilly smelly cheese dolcelatte edam port-salut hard cheese fromage frais rubber cheese. Everyone loves cheddar airedale fromage frais fromage frais st. agur blue cheese swiss croque monsieur. Monterey jack pepper jack.\n" +
            "Camembert de normandie mozzarella caerphilly. Airedale taleggio roquefort croque monsieur cheddar emmental cottage cheese cheesy feet. Edam ricotta feta roquefort airedale queso goat roquefort. Who moved my cheese cottage cheese chalk and cheese rubber cheese fromage frais paneer cheesy feet cheese on toast. Bavarian bergkase mascarpone.\n" +
            "Cheeseburger squirty cheese cheesy feet. Goat smelly cheese cow monterey jack the big cheese cut the cheese cheese and biscuits macaroni cheese. Everyone loves the big cheese pecorino monterey jack cheese and biscuits emmental squirty cheese cut the cheese. Danish fontina when the cheese comes out everybody's happy fondue st. agur blue cheese cheeseburger stinking bishop squirty cheese cow. Cauliflower cheese cheesy grin bocconcini.\n" +
            "Rubber cheese cheesecake who moved my cheese. Halloumi rubber cheese when the cheese comes out everybody's happy swiss danish fontina smelly cheese smelly cheese halloumi. Lancashire taleggio feta roquefort pepper jack bavarian bergkase mozzarella lancashire. Melted cheese airedale danish fontina stilton cheesy grin.\n" +
            "Bocconcini lancashire roquefort. Swiss monterey jack cut the cheese feta fromage squirty cheese cheesy feet cheese slices. Squirty cheese caerphilly cheese and wine fromage croque monsieur pepper jack bavarian bergkase boursin. Boursin edam.\n")
    private val coffeeIpsum: Ipsum = Ipsum("Coffee Ipsum", "To go cultivar galão sit aromatic skinny affogato medium americano roast so, spoon organic robusta galão single origin. Redeye roast, spoon, qui, in, shop, to go americano, milk iced, percolator viennese half and half, filter arabica java medium dripper. Single shot redeye so, french press redeye, bar strong con panna shop affogato variety, shop latte fair trade, extra coffee, half and half, turkish viennese sweet saucer macchiato est coffee. Crema, filter macchiato coffee lungo, aged, iced sweet extra rich grinder latte and caffeine cappuccino aged irish, wings, viennese that cup barista espresso.\n" +
            "Crema, roast, aftertaste mazagran decaffeinated mocha est caramelization foam, as con panna mug eu extraction foam cappuccino percolator, sweet saucer cup at mocha. Macchiato, strong, that froth, id fair trade aftertaste grinder, blue mountain iced bar wings, strong french press cappuccino aftertaste doppio con panna fair trade espresso. Froth, in blue mountain instant, aroma, instant cappuccino, macchiato instant iced rich arabica, that, organic instant aroma barista kopi-luwak wings. Extraction redeye caramelization trifecta robust french press foam single shot, seasonal, sweet shop milk, at spoon cream percolator, cultivar iced cultivar americano variety café au lait latte con panna.\n" +
            "Doppio, decaffeinated cream cortado plunger pot, brewed, seasonal extra, pumpkin spice sit, est skinny percolator mug, turkish, arabica café au lait dark whipped breve pumpkin spice qui id con panna. Americano est macchiato coffee, robust latte, sugar ristretto that caffeine, mocha, robusta mocha to go cream americano sit coffee coffee brewed. Cinnamon barista, percolator extraction americano foam, mug shop decaffeinated to go aroma shop coffee medium. Chicory, extraction flavour, java turkish et extra arabica id aromatic kopi-luwak lungo, cup, french press, cup at cultivar white redeye.\n" +
            "Seasonal cream, siphon, aged coffee, turkish latte pumpkin spice froth, body mocha java skinny sit eu, so, dark robust, shop robust body instant milk arabica. Iced redeye latte, caramelization espresso coffee medium aroma arabica, plunger pot extra sugar aroma carajillo. Skinny coffee wings, a foam, iced coffee kopi-luwak coffee viennese cream seasonal caramelization skinny, milk foam grinder, robust fair trade viennese est espresso. Coffee breve half and half, single origin at, macchiato barista foam java viennese, trifecta kopi-luwak con panna and ut mazagran steamed as doppio steamed.\n" +
            "Aged macchiato cream, skinny, java, aromatic dark so, extra french press mocha cappuccino mazagran. Wings sweet aroma, café au lait, froth, cappuccino kopi-luwak frappuccino lungo caffeine, mug coffee as, cream, flavour plunger pot fair trade half and half decaffeinated, ristretto sugar medium sit dripper. Carajillo, half and half, est, spoon acerbic, cinnamon turkish coffee milk cream, americano viennese foam half and half aged dark. Doppio bar, affogato, et cream dripper, roast milk steamed, froth milk chicory iced cortado viennese coffee doppio breve café au lait pumpkin spice roast.\n")
    private val pirateIpsum: Ipsum = Ipsum("Pirate Ipsum", "Yawl hail-shot deadlights yard rum. Bilged on her anchor ye dead men tell no tales cutlass barque. Gold Road provost Cat o'nine tails loot hornswaggle. Tackle Barbary Coast case shot Jolly Roger crimp. Rum man-of-war code of conduct bucko cable. Cable reef draught cog scallywag. Spyglass me sutler parley square-rigged. Cackle fruit Shiver me timbers holystone mizzen gangplank. Bilge Blimey Arr bring a spring upon her cable topsail. Long clothes rigging deadlights Brethren of the Coast Plate Fleet. Gibbet jib poop deck starboard ahoy. Aft draught warp scuttle six pounders. Shrouds cable Yellow Jack crimp belaying pin. Pink booty gally coffer to go on account.\n" +
            "Pirate Round long boat hands bilge rat swing the lead. Scuppers matey gally coffer coxswain. Swing the lead hands stern yawl red ensign. Sink me aye careen ho crimp. Scourge of the seven seas spike Cat o'nine tails log draught. Take a caulk lugsail walk the plank swab fathom. Holystone cackle fruit parley aft run a rig. Privateer cackle fruit pink swing the lead scuttle. Driver grapple pillage bilge cutlass. Bilged on her anchor stern gangway hearties Barbary Coast. Mutiny yo-ho-ho galleon poop deck quarter. Jolly Roger pillage bilge rat Barbary Coast landlubber or just lubber. Pirate Round squiffy cackle fruit Plate Fleet topgallant. Pirate galleon hardtack aft coffer.\n" +
            "Line avast heave to Pirate Round hulk. Swing the lead fluke execution dock yardarm gabion. Main sheet Davy Jones' Locker me Sea Legs ho. Booty chantey tack ballast haul wind. Spanker interloper clap of thunder fluke mutiny. Fluke scuttle pink me Shiver me timbers. Wherry jolly boat jack reef sails loot. Nipperkin Arr splice the main brace reef lee. Swab code of conduct rum lateen sail bring a spring upon her cable. Coxswain Sail ho yawl nipperkin ballast. Pinnace sheet shrouds topgallant Jack Tar. Gaff stern Nelsons folly Sail ho heave down. Hang the jib schooner gabion bilge rat long clothes. Admiral of the Black rope's end gangway ho galleon.\n" +
            "Piracy execution dock hempen halter Pirate Round six pounders. Quarterdeck overhaul landlubber or just lubber lass avast. Salmagundi mizzenmast Buccaneer yardarm code of conduct. Aye jolly boat red ensign mutiny interloper. Run a shot across the bow lee stern transom heave down. Prow take a caulk Chain Shot provost lanyard. Lad coffer deadlights strike colors loot. Davy Jones' Locker overhaul rutters bilge poop deck. Carouser Sink me red ensign parrel handsomely. Hearties overhaul black spot long boat red ensign. Chase guns take a caulk coxswain stern scallywag. Lugger bucko scurvy long boat draft. Gaff furl gibbet starboard hogshead. Fluke Sail ho keel heave down boom.\n" +
            "Hands bilged on her anchor yardarm gun pressgang. Ho yardarm killick swab splice the main brace. Barque pinnace black jack fore yo-ho-ho. Chain Shot Plate Fleet run a shot across the bow list topsail. Interloper Pieces of Eight lateen sail aye crack Jennys tea cup. Run a shot across the bow strike colors chantey heave down brigantine. Run a rig tender league knave careen. Ahoy lugsail chantey booty quarter. Weigh anchor yo-ho-ho sheet provost spike. Jolly boat walk the plank tack pressgang gaff. Furl pirate ahoy bilge water handsomely. Spirits splice the main brace doubloon squiffy gangplank. Fire ship marooned Brethren of the Coast Blimey grapple. Trysail rutters brigantine cog lass.\n")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.loremIpsum = loremIpsum
        binding.cheeseIpsum = cheeseIpsum
        binding.coffeeIpsum = coffeeIpsum
        binding.pirateIpsum = pirateIpsum

        // Populating the Spinner
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.lorem_types, android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.loremTypeSpinner.adapter = adapter

        binding.loremTypeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val currentType: String = binding.loremTypeSpinner.getItemAtPosition(position).toString()
                when (currentType) {
                    "Lorem Ipsum" -> {
                        binding.titleText.text = loremIpsum.type
                        binding.loremText.text = loremIpsum.content
                    }
                    "Cheese Ipsum" -> {
                        binding.titleText.text = cheeseIpsum.type
                        binding.loremText.text = cheeseIpsum.content
                    }
                    "Coffee Ipsum" -> {
                        binding.titleText.text = coffeeIpsum.type
                        binding.loremText.text = coffeeIpsum.content
                    }
                    "Pirate Ipsum" -> {
                        binding.titleText.text = pirateIpsum.type
                        binding.loremText.text = pirateIpsum.content
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.d("LoremGenerator :: ","onNothingSelected() is Called! Doing Absolutely Nothing....")
            }

        }

        binding.creatorButton.setOnClickListener {
            pickCreatorName(binding.creatorButton)
        }
        binding.creatorText.setOnClickListener {
            changeCreatorName(it)
        }
    }

    private fun pickCreatorName(view: View) {
        binding.apply {
            creatorText.text = "by " + creatorFill.text.toString()
            creatorFill.visibility = View.GONE
            view.visibility = View.GONE
            loremTypeSpinner.visibility = View.GONE
            creatorText.visibility = View.VISIBLE
        }

        val tip = Toast.makeText(this, "Tap your name to change settings", Toast.LENGTH_SHORT)
        tip.setGravity(Gravity.CENTER, 0, -300)
        tip.show()

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun changeCreatorName(view: View) {
        binding.apply {
            view.visibility = View.GONE
            creatorFill.visibility = View.VISIBLE
            creatorButton.visibility = View.VISIBLE
            loremTypeSpinner.visibility = View.VISIBLE
            creatorFill.requestFocus()
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.creatorFill, 0)
    }
}
