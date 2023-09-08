# JacocoHiltEntryPointCoverageTestApp

Run `jacocoTestReport` task to generate JaCoCo coverage.

You will see output similar to this:
```
> Task :app:jacocoTestReport
[ant:jacocoReport] Classes in bundle 'app' do not match with execution data. For report generation the same class files must be used as at runtime.
[ant:jacocoReport] Execution data for class com/example/jacocohiltentrypointcoveragetestapp/MainFragment does not match.
[ant:jacocoReport] Execution data for class com/example/jacocohiltentrypointcoveragetestapp/MainActivity does not match.
```

Current issues:
1. On `master` branch, open up the generated html JaCoCo report.  You will see that `MainFragment` has no coverage.  On `lifted-workaround` you will see that by adding the `MainFragmentLifted` class, JaCoCO coverage for `MainFragment` is reported.  (See https://issuetracker.google.com/issues/161300933)
