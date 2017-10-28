package covuni.a300cemcovunistudenthelper;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;

/**
 * Created by Holmesy on 20/10/2017.
 */

public class TimeLineFragment extends ListFragment {
    //Put together by using official Fabric Doc. HERE: https://dev.twitter.com/twitterkit/android/show-timelines
    //and https://dev.twitter.com/twitterkit/android/installation


    //TODO: Change to recycler view.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.timeline, container, false);


        TwitterConfig config = new TwitterConfig.Builder(this.getActivity())
                .logger(new DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(new TwitterAuthConfig("vGNHifQS3nYEy7mYAfTvzJSMq", "RTqZ4RCWAklp0aCaGPegJE6J97oQaWI6fVwXk3FWd8F9Y93QaP"))
                .debug(true)
                .build();
        Twitter.initialize(config);

        final UserTimeline userTimeline = new UserTimeline.Builder()
                .screenName("CoventryUniNews")
                .build();
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(this.getActivity())
                .setTimeline(userTimeline)
                .build();
        setListAdapter(adapter);
        return view;
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

    }
}
