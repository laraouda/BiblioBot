import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;
import okhttp3.*;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main extends ListenerAdapter {
    public static void main(String[] args) {
        JDA jda = JDABuilder.createDefault("MTExNzgxODQ3NjgxMjMyNDg4NA.GKEV1u.BNJRYouSIJHYJ5zUQKYgeHrx4cTQsl7NRQk4hE")
                .enableIntents(GatewayIntent.MESSAGE_CONTENT) // enables explicit access to message.getContentDisplay()
                .build();
        //You can also add event listeners to the already built JDA instance
        // Note that some events may not be received if the listener is added after calling build()
        // This includes events such as the ReadyEvent
        jda.addEventListener(new Main());
        updatecommands(jda);

    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        super.onSlashCommandInteraction(event);


        switch (event.getName()) {
            case "drake":
                event.reply("house yasta").queue();
                break;
            case "etsh":
                event.reply("etsh enta basic engineer moot, respectfully").queue();
                break;
            case "nokat":
                event.reply(nokat()).queue();
                break;
            case "morad":
                event.reply("ya deeny ya farida :3").queue();
                break;
            case "dark":
                event.reply(nokatSooda()).queue();
                break;
            case "info":
                event.deferReply().queue();
                String bookName = event.getOption("bookname").getAsString().replace(" ", "_");
                String url = "https://openlibrary.org/search.json?q=" + bookName;
                try {
                    JSONObject json = new JSONObject(IOUtils.toString(new URL(url).openStream(), Charset.forName("UTF-8").toString()));
                    JSONArray docs = json.getJSONArray("docs");
                    if (docs.length() == 0) {
                        event.reply("No results found.").queue();
                        return;
                    }
                    JSONObject firstDoc = docs.getJSONObject(0);
                    String title = firstDoc.getString("title");
                    String author = firstDoc.getJSONArray("author_name").getString(0);
                    String publishYear = firstDoc.optString("first_publish_year", "N/A");
                    String publisher = firstDoc.optString("publisher", "N/A");
                    String cover = firstDoc.optString("cover_i", "1");

                    EmbedBuilder embedBuilder = new EmbedBuilder()
                            .setTitle(title)
                            .addField("Author", author, false)
                            .setThumbnail("https://covers.openlibrary.org/b/id/" + cover + "-M.jpg")
                            .addField("Publish Year", publishYear, false)
                            .addField("Publisher", publisher, false);

                    event.getHook().editOriginalEmbeds(embedBuilder.build()).queue();

                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }

        }
    }


    public String nokat() {
        List<String> nokatlist =
                Arrays.asList(
                        "واحدة اتجوزت واحد شخصيته مهزوزة . ركبت له أريل",
                        " مره واحد عداه العيب اخد الي بعده.",
                        "واحد خلقه ضاق اداه لأخوه الصغير.",
                        " مره محامي عايز يخس ماخلاش حد يوكله",
                        "مره واحد فكهاني واحد ربط هاني",
                        " غبي اتهموه بالذكاء طلع براءة.",
                        "ليش الشيطان نحيف , لانو الشيطان الرجيم",
                        "دجاجة أنتحرت .. وكتبت في وصيتها …. خلوا ماجي ينفعكم.",
                        " بيبسي وبطاط وهمبرجر يتسابقون . لماذا؟ وجبة سريعة",
                        "مره واحد اخرس بلع 14 قرش اتكلم دقيقه",
                        "صعيدي حبوا يدهنوا اتوبيس, 99 شالو االاتوبيس رايحين جاين بيه, وواحد مسك الفرشة",
                        " بيقولك مره واحد متطفل خلف بنت سماها داليدا",
                        " مره فرخه شربت سجاره جالها ديك تنفس",
                        "مرة واحد شغال في بنك اتزحلق وقع على القرض",
                        "واحده اتجوزت من ورا ابوها قام لف وشافها",
                        " مره سفاح قتل ظابط راح رانن على 122 قالهم بقيتوا 121",
                        "مره مدير عام ومدير غرق",
                        "مره حديده صدت وقفوها جون",
                        "مره واحد دخل عماره ملقاش الحارس بتاعها قام جاب جول",
                        "مره واحد اشتري شاشتين واحده بلازما والتانيه من غير لازمه",
                        "مره واحد راح لجدته قالها افتحي الباب انا حفيدك قالتله هتفيدني بايه ؟",
                        "مره مدرس عربي جاب كلب عشان بيخاف من النصوص",
                        "مره واحد بيلعب كاراتيه علي امل انه يبقي شيبسي",
                        "في ثلاثة محششين ركبوا هلكوبتر لما حسوا بالبرد طفوا المروحه .",
                        "مرة اتنين راحو يحلقو واحد حلق والتانى غويشة .",
                        "مره واحد اشتري قلمين واحد كتب بيه والتاني كتب سي",
                        "ليه الارنب بيخاف من القهوه ؟ عشان فيها السحلب المكار",
                        "مره مدير عام ومدير غرق",
                        "مره مدير خاص ومدير معرفش يغوص",
                        "مره واحد ركب دماغه عمل حادثه",
                        "مره بسبوسه أتخانقت مع كنافه شدو شعر بعض وهاتك يا sweet",
                        "اخطبوط مرة قاعد زعلان اوي عشان مش عارفه ايده من رجله.",
                        "مدرس كمبيوتر بيزعق هو و ابنه و قاله \"كيبورد و بقيت تعلي  صوتك\"",
                        "مسطول أتجوز صينية قالتله مالك ساكت ليه؟ قالها مش عارف افتكرتك نايمة.",
                        "مرة فكهاني اتخانق مع صاحبه سب التين.",
                        "مرة واحدة اسمها ساندي دخلت هندسة بقت ساندي متر مربع.",
                        "مرة شرطي مرور خلّف ولد بيتكلم بالإشارة.",
                        "مرة have ضربت has قامت has قالتلها has بي الله ونعم الوكيل فيكي.",
                        "واحد بخيل رايح يزور امه فى المستشفى لقى الباب مكتوب عليه ادفع راح لافف وراجع وقال ابقا اروح ازورها فى البيت لما ترجع.",
                        "واحد مسطول اشتغل سواق تاكسي، شاورتله واحده، وقف وسألها “رايحه فين؟” قالتله “المهندسين” قالها “روحي بس ما تتأخريش” .",
                        "واحد مسطول شاف قطة اخدها البيت لمراته وقالها:- شايفه القرد؟ قالتله:- دي قطة يامنيل قالها:- انا بكلم القطه حد كلمك.",
                        "حكمة محشش ” إذا شفت الذبان يدور فوق راسكأعرف ان تفكيرك زباله.",
                        "مره نجار عجبه بوست راح مشنيره.",
                        "مره نقاش بنته تعبت سنفرها برا.",
                        "مره مهندس عايز يسبب الشغل قالهم انا مستطيييل.",
                        "مرة مهندس زراعي اترفد من الشغل عشان بيعمل مشاتل",
                        "في وحش اكل تونا صار وحشتونا",
                        "كبوريا بتتخانق مع جمبري بتقولها اكيد السمك اللي نقلك الكلام  قالتلها  والله السمك مقلي",
                        "مره 4 اسمهم طارق قعدوا مع بعض عملوا قاعدة طوارئ",
                        "بيقولكوا مره واحد دخل كنتاكي قال للراجل عايز تشيكن وينجز الراجل قاله بص هتستعجلني مش هعملك حاجه",
                        "مره نجار ولاده بيقولوله تصبح ع خير قالهم window من أهله",
                        "مرة كوباية عصير جوزها مات قالت اه يا juice ي",
                        "رسام قالوله رسمك وحش بس هو ما Sketch .",
                        "مرة واحد حلاق جاله اسهال عمل حمام كريم 😂😂",
                        "مرة Ali Gatie عطس وقال It's you",
                        "مرة اسد خبط ف اسد قاله سوري مكنش اسدي",
                        "مره شرطي فتح محل حلويات سماه التورته في خدمة الشعب",
                        "مرة شمس شرقت شربوها مياه😁😁😁",
                        "مرة مذيع طلع فاصل، رجع مشحون"
                , "بعض الناس ينسون و البعض الاخر شاي بالنعنع");

        Random random = new Random();
        int size = nokatlist.size();
        int randindex = random.nextInt(size);
        String randelement = nokatlist.get(randindex);
        return randelement;

    }

    public String nokatSooda() {
        OkHttpClient client = new OkHttpClient();
        HttpUrl url = new HttpUrl.Builder().scheme("https").host("v2.jokeapi.dev").addPathSegment("joke").addPathSegment("Dark").addQueryParameter("blacklistFlags", "").addQueryParameter("format", "txt").build();
        Request request = new Request.Builder().url(url).get().build();
        Call call = client.newCall(request);
        try (Response response = call.execute()) {
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void updatecommands(JDA hehe) {
        hehe.updateCommands().addCommands(
                Commands.slash("info", "returns information of given book").addOption(OptionType.STRING, "bookname", "enter the name of the book you want to search for", true),
                Commands.slash("drake", "she3ar drake"),
                Commands.slash("morad", "try and see!!"),
                Commands.slash("dark", "nokat sooda for the haha's"),
                Commands.slash("nokat", "nokat masreya aseela :)"),
                Commands.slash("etsh", "khod ya meow :3")

        ).queue();

    }


}

