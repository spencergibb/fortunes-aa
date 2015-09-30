package fortunes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FortunesServiceApplication {

	Random random = new Random();

	@Autowired
	private FortuneRepository repository;

	@RequestMapping("/random")
	public Fortune random() {
		//TODO: this sucks at large size
		List<Fortune> fortunes = toList(repository.findAll());
		return fortunes.get(random.nextInt(fortunes.size()));
	}

	private List<Fortune> toList(Iterable<Fortune> all) {
		return StreamSupport.stream(all.spliterator(), false).collect(Collectors.toList());
	}

	@RequestMapping("/insert")
	public List<Fortune> insert() {
		List<Fortune> fortunes = new ArrayList<>();
		for (String text : INITIAL_FORTUNES) {
			String sha256 = DigestUtils.sha256Hex(text.getBytes());
			fortunes.add(new Fortune(sha256, text));
		}

		repository.save(fortunes);

		return fortunes;
	}

    public static void main(String[] args) {
        SpringApplication.run(FortunesServiceApplication.class, args);
    }

	public static String[] INITIAL_FORTUNES = {
			"People are naturally attracted to you.",
			"You learn from your mistakes... You will learn a lot today.",
			"If you have something good in your life, don't let it go!",
			"What ever you're goal is in life, embrace it visualize it, and for it will be yours.",
			"Your shoes will make you happy today.",
			"You cannot love life until you live the life you love.",
			"Be on the lookout for coming events; They cast their shadows beforehand.",
			"Land is always on the mind of a flying bird.",
			"The man or woman you desire feels the same about you.",
			"Meeting adversity well is the source of your strength.",
			"A dream you have will come true.",
			"Our deeds determine us, as much as we determine our deeds.",
			"Never give up. You're not a failure if you don't give up.",
			"You will become great if you believe in yourself.",
			"There is no greater pleasure than seeing your loved ones prosper.",
			"You will marry your lover.",
			"A very attractive person has a message for you.",
			"You already know the answer to the questions lingering inside your head.",
			"It is now, and in this world, that we must live.",
			"You must try, or hate yourself for not trying.",
			"You can make your own happiness.",
			"The greatest risk is not taking one.",
			"The love of your life is stepping into your planet this summer.",
			"Love can last a lifetime, if you want it to.",
			"Adversity is the parent of virtue.",
			"Serious trouble will bypass you.",
			"A short stranger will soon enter your life with blessings to share.",
			"Now is the time to try something new.",
			"Wealth awaits you very soon.",
			"If you feel you are right, stand firmly by your convictions.",
			"If winter comes, can spring be far behind?",
			"Keep your eye out for someone special.",
			"You are very talented in many ways.",
			"A stranger, is a friend you have not spoken to yet.",
			"A new voyage will fill your life with untold memories.",
			"You will travel to many exotic places in your lifetime.",
			"Your ability for accomplishment will follow with success.",
			"Nothing astonishes men so much as common sense and plain dealing.",
			"Its amazing how much good you can do if you dont care who gets the credit.",
			"Everyone agrees. You are the best.",
			"Life consist not in holding good cards, but in playing those you hold well.",
			"Jealousy doesn't open doors, it closes them!",
			"It's better to be alone sometimes.",
			"When fear hurts you, conquer it and defeat it!",
			"Let the deeds speak.",
			"You will be called in to fulfill a position of high honor and responsibility.",
			"The man on the top of the mountain did not fall there.",
			"You will conquer obstacles to achieve success.",
			"Joys are often the shadows, cast by sorrows.",
			"Fortune favors the brave.",
	};
}
