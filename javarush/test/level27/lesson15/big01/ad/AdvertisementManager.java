package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import java.util.*;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException {
        if (storage.list().isEmpty()) {
            throw new NoVideoAvailableException();
        }
        List<Advertisement> list = storage.list();
        List<Advertisement> selected = new ArrayList<>();
        Collections.sort(list, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                return (int) (o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying());
            }
        });
        int show = timeSeconds;
        for (Advertisement a : list){
            if (show >= a.getDuration()){
                selected.add(a);
                show -= a.getDuration();
            }
        }

        if (selected.isEmpty()) {
            throw new NoVideoAvailableException();
        }
        Collections.sort(selected, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                long differenceProceeds = o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying();
                if (differenceProceeds != 0) {
                    return (int)differenceProceeds;
                } else {
                    long proceedsPerSecond1 = (1000 * o1.getAmountPerOneDisplaying() / o1.getDuration());
                    long proceedsPerSecond2 = (1000 * o2.getAmountPerOneDisplaying() / o2.getDuration());
                    return (int) (proceedsPerSecond1 - proceedsPerSecond2);
                }
            }
        });
        for (Advertisement advertisement : selected) {
            String pattern = "%s is displaying... %s, %s";
            String proceeds = String.valueOf(advertisement.getAmountPerOneDisplaying());
            String proceedsPerOneSecond = String.valueOf((int)(1000.0 * advertisement.getAmountPerOneDisplaying()
                    / advertisement.getDuration()));
            ConsoleHelper.writeMessage(String.format(pattern, advertisement.getName(), proceeds, proceedsPerOneSecond));
            advertisement.revalidate();
        }
    }
}
