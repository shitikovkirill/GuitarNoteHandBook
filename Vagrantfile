$rootScript = <<-SHELL

		echo -e "\e[34mUser name $USER"

		apt-get update
		apt-get upgrade

		apt-get install apt-transport-https ca-certificates curl software-properties-common

		curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -

		apt-key fingerprint 0EBFCD88

		add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"

		apt-get update

		apt-get install -y docker-ce

		curl -L https://github.com/docker/compose/releases/download/1.17.0/docker-compose-`uname -s`-`uname -m` -o /usr/local/bin/docker-compose

		chmod +x /usr/local/bin/docker-compose

  	SHELL

$prepare = <<-SHELL

		echo -e "\e[34mUser name $USER"

		sudo usermod -aG docker $USER

		su - $USER

		#sudo systemctl enable docker

		echo manual | sudo tee /etc/init/docker.override

		if [ -d "/home/vagrant/project" ]
    then
        echo "#### Directory already exist ####"
    else
        echo "#### Created link ####"
        ln -s /vagrant /home/vagrant/project
    fi

	SHELL

$startDocker = <<-SHELL

		echo -e "\e[34mUser name $USER"

		sudo service docker restart

		docker --version

		docker-compose --version

		cd /vagrant

		docker-compose build

		docker-compose up

	SHELL

Vagrant.configure("2") do |config|
    config.vm.box = "ubuntu/trusty64"

    config.vm.provider "virtualbox" do |vb|
        vb.memory = 1024
        vb.cpus = 2
    end

    config.ssh.shell = "bash -c 'BASH_ENV=/etc/profile exec bash'"

    config.vm.network :forwarded_port, guest: 8000, host: 8000
    config.vm.network :forwarded_port, guest: 8888, host: 8888
    config.vm.network :forwarded_port, guest: 4200, host: 4200

    config.vm.provision :shell, inline: $rootScript

    config.vm.provision :shell, privileged: false, inline: $prepare

    config.vm.provision :shell, run: 'always', privileged: false, inline: $startDocker
end
