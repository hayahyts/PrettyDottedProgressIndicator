# PrettyDottedProgressIndicator

A dotted progress bar to for example show the page we're on. See GIF.

# Step 1. Add the following in your root build.gradle at the end of repositories:

```
	allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}
```


# Step 2. Add the dependency

```
  dependencies {
	        compile 'com.github.hayahyts:PrettyDottedProgressIndicator:1.0.0'
	}
```

# You can now use it in your layout file like this:

```
  <com.hayahyts.dottedprogressindicator.DottedProgressBar
        android:id="@+id/dotted_progress_bar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:orientation="horizontal" />
```

# Get it in the Activity/Fragment like this:

```
  DottedProgressBar dottedProgressBar = findViewById(R.id.dotted_progress_bar);
  dottedProgressBar.setDotCount(TOTAL_SIZE);
  dottedProgressBar.setCurrent(current, true);
```

# Sample App
![Sample App](https://github.com/hayahyts/PrettyDottedProgressIndicator/blob/master/art/activity.gif)

