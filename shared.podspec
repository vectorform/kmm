Pod::Spec.new do |spec|
    spec.name                     = 'JokeAPI'
    spec.version                  = '0.0.1'
    spec.summary                  = 'Joke API'
    spec.homepage                 = 'https://www.vectorform.com'
    spec.source                   = { :git => "https://bitbucket.org/vectorform/vectorform_kmm.git", :branch => 'master', :tag => spec.version.to_s }
    spec.authors                  = 'Vectorform LLC'
    spec.license                  = 'BSD'

    spec.vendored_frameworks      = "shared/build/bin/iosArm64/releaseFramework/iOSArm_shared.framework", "shared/build/bin/iosX64/releaseFramework/iOSX_shared.framework"
    spec.module_name              = "#{spec.name}_umbrella"

    spec.ios.deployment_target = '14.0'

    spec.static_framework = true

    spec.pod_target_xcconfig = {
        'KOTLIN_PROJECT_PATH' => ':shared',
        'PRODUCT_MODULE_NAME' => 'shared',
    }
end